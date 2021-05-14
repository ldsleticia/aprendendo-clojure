(ns loja.aula5
 (:require [loja.db :as l.db]
           [loja.logic :as l.logic]))

(defn gastou-bastante? [info-do-usuario]
(> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
      (println "keep" (keep gastou-bastante? resumo)))
