(ns curso.criando-thread-last)

; THREAD LAST
(->> pedido
     vals
     (map preco-dos-produtos)
     (reduce +))

(defn total-de-preco-dos-produtos [produto]
  (* (:quantidade valor) (:preco valor)))



(def pedido{ :mochila {:quantidade 2, :preco 80}

            :camiseta {:quantidade 3, :preco 40}

            :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "filtrando gratuítos")
(println (filter gratuito? (vals pedido)))