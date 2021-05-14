(ns hospital.colecoes
 (:use [clojure pprint]))

; predicado é uma função
; pop no vetor tira o último elemento
; conj no vetor coloca no último elemento
(defn testa-vetor[]
  (let [espera [111 222]]
    (println espera)
    (println (conj espera 333))
    (println (conj espera 444))
    (println (pop espera))
    ))

(testa-vetor)

; pop na lista tira do primeiro elemento
; conj na lista coloca no primeiro elemento
(defn testa-lista[]
  (let [espera '(111 222)] ; uma aspas simples só para fazer a lista
    (println espera)
    (println (conj espera 333))
    (println (conj espera 444))
    (println (pop espera))
    ))

(testa-lista)

;pop não é feito porque o conjunto não tem ordem
(defn testa-conjunto[]
  (let [espera #{111 222}]
    (println espera)
    (println (conj espera 333))
    (println (conj espera 444))
    ))

(testa-conjunto)

; em clojure uma fila não se cria com atalhos
; é preciso criar uma lista vazia primeiro
; para que volte algo legível, é preciso colocar dentro de uma seq
(defn testa-fila[]
  (let [espera (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
    (println "fila")
    (println (seq espera))
    (println (seq (conj espera "333")))
    (println (seq (pop espera))) ;o resto exceto o primeiro
    (println (peek espera)) ;só o primeiro
    ;(pprint espera) por padrão recebe só um argumento
    ))

(testa-fila)