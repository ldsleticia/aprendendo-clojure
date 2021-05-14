(ns hospital.aula4
  (:use [clojure pprint])
  (:require [hospital.logic :as h.logic]
            [hospital.model :as h.model]))

(defn chega-sem-malvado! [hospital pessoa]
  (swap! hospital h.logic/chega-em :espera pessoa)
  (println "apois inserir" pessoa))

;força o map a ser eager e o faz criar um vetor
(defn simula-um-dia-em-paralelo-com-mapv
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]]
        (mapv #(.start (Thread. (fn [] (chega-sem-malvado! hospital %)))) pessoas)

        (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

;(simula-um-dia-em-paralelo-com-mapv)


(defn simula-um-dia-em-paralelo-com-mapv-refatorada
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        starta-tread-de-chegada #(.start (Thread. (fn [] (chega-sem-malvado! hospital %))))]
    (mapv  starta-tread-de-chegada pessoas)

    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

;(simula-um-dia-em-paralelo-com-mapv-refatorada)



(defn starta-thread-de-chegada
  ([hospital]
   (fn [pessoa] (starta-thread-de-chegada hospital pessoa)))
  ([hospital pessoa]
   (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa))))))


(defn simula-um-dia-em-paralelo-com-mapv-extraida
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]]
    (mapv (starta-thread-de-chegada hospital pessoas)

    (.start (Thread. (fn [] (Thread/sleep 3000)
                       (pprint hospital)))))))

;(simula-um-dia-em-paralelo-com-mapv-extraida)


(defn starta-thread-de-chegada
  [hospital pessoa]
  (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa)))))

  (defn simula-um-dia-em-paralelo-com-doseq
    []
    (let [hospital (atom (h.model/novo-hospital))
          pessoas ["111", "222", "333", "444", "555", "666"]]

      (doseq [pessoa pessoas]
                (starta-thread-de-chegada hospital pessoa))
      (.start (Thread. (fn [] (Thread/sleep 1000)
                        (pprint hospital))))))

; (simula-um-dia-em-paralelo-com-doseq)


(defn simula-um-dia-em-paralelo-com-dotimes
  []
  (let [hospital (atom (h.model/novo-hospital))]

    (dotimes [pessoa 6]
      (starta-thread-de-chegada hospital pessoa))
    (.start (Thread. (fn [] (Thread/sleep 1000)
                       (pprint @hospital))))))

(simula-um-dia-em-paralelo-com-dotimes)