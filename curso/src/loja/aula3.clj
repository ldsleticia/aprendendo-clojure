(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (loja.db/todos-os-pedidos))

(println (group-by :usuario l.db/todos-os-pedidos))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

(vals (group-by :usuario (l.db/todos-os-pedidos)))

(defn total-dos-pedidos
  [pedidos]
  -1)

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  { :usuario-id usuario
    :total-de-pedidos (count pedidos)}
    :preco-total (total-dos-pedidos pedidos))

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(println "PEDIDOS")

(defn total-do-item
  [[item-id detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (reduce + (map total-do-item pedido)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println)