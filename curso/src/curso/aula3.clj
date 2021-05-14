(ns curso.aula3)

(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [desconto 0.1]
      (* valor-bruto (- 1 desconto)))
    valor-bruto))

(print
  (valor-descontado 1000)
  (valor-descontado 100))

;alt shift j tira o que está dentro do () e alt shift k coloca dentro do parêntese

;FUNÇÃO PREDICADA || PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))

(defn aplicar-desconto?
  [valor-bruto]
  (println "chamando a versão when")
  (when (> valor-bruto 100)
    true))

(println (aplicar-desconto? 1000))
(println (aplicar-desconto? 100))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado-1
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado-1 mais-caro-que-100? 1000))
(println (valor-descontado-1 mais-caro-que-100? 100))

(defn estritamente-positivo? [x] (> x 0))
(println (estritamente-positivo? 10))