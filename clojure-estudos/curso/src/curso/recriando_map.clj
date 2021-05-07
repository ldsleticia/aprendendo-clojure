(ns curso.recriando-map)

;CRIANDO MEU MAP
(map println ["daniela", "joao", "jose", "amaral", "janaina", "ana"])
(println (first ["daniela", "joao", "jose", "amaral", "janaina", "ana"]))
(println (rest ["daniela", "joao", "jose", "amaral", "janaina", "ana"])) ;quando o próximo é vazio, volta um vetor vazio
(println (next ["daniela", "joao", "jose", "amaral", "janaina", "ana"])) ;quando o próximo é vazio volta nill

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println ["daniela", "joao", "jose", "amaral", "janaina", "ana"])