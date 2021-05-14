(ns hospital.logic)

(defn cabe-na-fila? [hospital departamento]
  (-> hospital
      (get,,, departamento)
      count,,,
      (<,,, 5)))



 (defn chega-em
    [hospital departamento pessoa]
      (if (cabe-na-fila? hospital departamento)
        (update hospital departamento conj pessoa)
          (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))) )

(defn atende
  [hospital departamento]
  (update hospital departamento pop)
  )


(defn chega-em-pausado-logando
  [hospital departamento pessoa]
  (println "Tentando adicionar a pessoa" pessoa)
  (Thread/sleep (* (rand) 2000))
  (if (cabe-na-fila? hospital departamento)
    (do
    ;(Thread/sleep (* (rand) 2000))
    (println "Dei o update" pessoa)
    (update hospital departamento conj pessoa)
    )
  (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))

(defn proxima
  [hospital departamento]
  (-> hospital
      departamento
      peek)
  )

(defn transfere
  [hospital de para]
  (let [pessoa (proxima hospital de)]
    (-> hospital
        (atende de)
        (chega-em para pessoa))))

(defn atende-completo
  [hospital departamento]
  {:paciente (update hospital departamento peek)
   :hospital (update hospital departamento pop)})
