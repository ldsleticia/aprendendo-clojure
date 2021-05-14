(ns curso.recriando-reduce)

;RECRIANDO REDUCE
(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(println (conta 0 ["daniela", "joao", "jose", "amaral", "janaina", "ana"]))

(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))
(minha-funcao 1)
(minha-funcao 1 2)

(defn conta
  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

(println (conta 0 ["daniela", "joao", "jose", "amaral", "janaina", "ana"]))
