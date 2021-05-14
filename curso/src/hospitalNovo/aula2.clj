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

(let [particular (->PacienteParticular 15, "Guilherme", "18/09/1981")]
(pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 500)))