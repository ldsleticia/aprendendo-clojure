(ns testes.hospital.logic)

;(defn cabe-na-fila?
;  [hospital departamento]
;  ;(count (get hospital departamento))
;  (when-let [fila (get hospital departamento)]
;    (-> fila
;        count
;        (< 5))))

;(defn cabe-na-fila?
;  [hospital departamento]
;   (-> hospital
;       departamento
;       count
;       (< 5)))

;qualquer uma que der nil retorna nulo
(defn cabe-na-fila?
  [hospital departamento]
  (some-> hospital
          departamento
          count
          (< 5)))

;(defn chega-em
;  [hospital departamento pessoa]
;  (if (cabe-na-fila? hospital departamento)
;    (update hospital departamento conj pessoa)
;    (throw (ex-info "Não cabe mais nintguém nesse departamento" {:paciente pessoa :tipo :impossivel-colocar-pessoa-na-fila}))))

(defn chega-em
  [hospital departamento pessoa]
  (if (cabe-na-fila? hospital departamento)
    (update hospital departamento conj pessoa)
    (throw (ex-info "Não cabe ninguém neste departamento" {:paciente pessoa}))))

(defn atende
  [hospital departamento]
  (update hospital departamento pop))

(defn proxima
  "Retorna o próximo paciente da fila"
  [hospital departamento]
  (-> hospital
      departamento
      peek))

(defn transfere
  "Transfere o próximo paciente da fila 'de' para a fila 'para'"
  [hospital de para]
  (let [pessoa (proxima hospital de)]
    (-> hospital
        (atende de)
        (chega-em para pessoa))))