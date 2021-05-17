(ns hospitalNovo.aula2
  (:use [clojure pprint]))

(defrecord Paciente [id, nome, nascimento])

; Paciente ===> + plano de saúde
; Paciente ===> + 0

(defrecord PacienteParticular [id, nome, nascimento])
(defrecord PacientePlanoDeSaude [id, nome, nascimento, plano])

(defprotocol Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente, procedimento, valor]
    (>= valor 50)))

(extend-type PacientePlanoDeSaude
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente, procedimento, valor]
    (let [plano (:plano paciente)]
      (not (some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15, "Guilherme", "18/09/1981")
      plano (->PacientePlanoDeSaude 16, "Letícia", "16/04/1996" [:raio-x, :ultrassom])]
(pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 500))
(pprint (deve-assinar-pre-autorizacao? plano, :raio-x, 500))
(pprint (deve-assinar-pre-autorizacao? plano, :coleta-de-sangue, 500)))
