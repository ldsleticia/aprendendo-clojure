(ns curso.aula5)

;FORMAS DE RETORNAR O QUE HÁ NO MAPA
(def pedido
  (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)

(println (pedido :mochila)) ;se o pedido for nulo, aqui aparece NullPointerException

(println (get pedido :mochila))

(println (get pedido :cadeira)) ;por padrão retorna nill se não existe no mapa

(println (get pedido :cadeira {})) ;aqui definimos por padrão que voltaria um
; mapa vazio se não tivesse no mapa original

(println (:mochila pedido))

(println (:cadeira pedido)) ;por padrão retorna nill se não existe no mapa

(println (:cadeira pedido{})) ;aqui definimos por padrão que voltaria um mapa vazio se não tivesse no mapa origina