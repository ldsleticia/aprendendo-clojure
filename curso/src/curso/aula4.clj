(ns curso.aula4)

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(def precos [30 700 1000])
(println (get precos 0))

(println (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))
(println(filter aplica-desconto? precos))
(println(reduce + precos))

(def estoque {"Mochila" 10,
              "Camiseta" 5})
(println estoque)
(println "temos" (count estoque) "elementos") ;count conta os elementos
(println "chaves são:" (keys estoque)) ;mostra as chaves de um array que no caso desse são as strings
(println "valores são:" (vals estoque)) ;mostra os valores do array

(def estoque {
              :mochila 10
              :camiseta 5
              })

(println (assoc estoque :cadeira 3))
(println (update estoque :mochila inc))
(println estoque) ;imutável!
(println (update estoque :mochila #(- % 3 )))
(println (dissoc estoque :mochila))
(println estoque)

(def pedido{
            :mochila {:quantidade 2, :preco 80}

            :camiseta {:quantidade 3, :preco 40}

            })
(println pedido)
