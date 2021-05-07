(ns curso.aula2)

(defn aplica-desconto
  "Retorna o valor descontado que é igual a 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9))
 (aplica-desconto 1000)

(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (* valor-bruto(- 1 0.1)))
(valor-descontado 1000)

(defn valor-descontado-2
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto 0.1]
    (* valor-bruto(- 1 desconto))))
(valor-descontado-2 100)

(defn valor-descontado-3
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (* valor-bruto(- 1 desconto))))
(valor-descontado-3 100)

(class 90N)
(class 90M)

(defn valor-descontado-4
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (if(> valor-bruto 100)
    (let [desconto 0.1]
      (* valor-bruto(- 1 desconto)))
    valor-bruto))

(valor-descontado-4 1000)
(valor-descontado-4 100)

