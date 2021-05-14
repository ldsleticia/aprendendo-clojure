(ns curso.aula6)

;ENCADEAMENTO / THREADING FIRST
(println (:quantidade (:mochila pedido))) ;mostra a quantidade dentro do mapa mochila
(println (update-in pedido [:mochila :quantidade] inc)) ;incrementa na quantidade que está dentro do mapa mochila
(println (-> pedido
             :mochila
             :quantidade)) ;-> significa começar | :mochila é chamada como função | em cima do resultado da função :mochila chamamos a :quantidade. Em resumo, você entra no seu pedido, no seu produto e vê a quantidade de itens qu etem lá dentro

; alt + 1 roda o projeto no intellij

(def pedido { :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor)
  15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos pedido [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))
