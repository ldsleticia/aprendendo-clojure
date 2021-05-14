(ns hospital.aula6
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))


(defn cabe-na-fila? [fila]
  (-> fila
      count
      (< 5)))

(defn chega-em [fila pessoa]
  (if (cabe-na-fila? fila)
  (conj fila pessoa)
  (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))

(defn chega-em! [hospital pessoa]
  (let [fila (get hospital :espera)]
    (ref-set fila (chega-em @fila pessoa))))

(defn chega-em-alter! [hospital pessoa]
  (let [fila (get hospital :espera)]
    (alter fila chega-em fila pessoa)))

(defn simula-um-dia []
  (let [hospital {:espera       (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}]
    (dosync
      (chega-em! hospital "guilherme")
      (chega-em! hospital "maria")
      (chega-em! hospital "joao")
      (chega-em! hospital "jose")
      (chega-em! hospital "daniela")
      ;(chega-em! hospital "lucia")
      )
    (pprint hospital)))

;(simula-um-dia)


(defn async-chega-em! [hospital pessoa]
  (future (Thread/sleep (rand 5000))
          (dosync
            (println "Tentando o código sincronizado " pessoa)
            (chega-em! hospital pessoa))))

(defn simula-um-assync []
  (let [hospital {:espera       (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}]
    (dotimes [pessoa 10]
      (async-chega-em! hospital pessoa))))

(simula-um-assync)