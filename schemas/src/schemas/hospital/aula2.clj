(ns schemas.hospital.aula2
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

;não precisa usar o :-
(def Paciente
  "Schema de um paciente"
  {:id s/Num, :nome s/Str})

(pprint (s/explain Paciente))
(pprint (s/validate Paciente {:id 15, :nome "Guilherme"}))
;(pprint (s/validate Paciente {:id 15, :name "Guilherme"}))  ;esse não funciona por causa do schema e o typo é diferente
;(pprint (s/validate Paciente {:id 15, :name "Guilherme", :plano [:raio-x]})) ; não funciona porque existe uma chave a mais

(s/defn novo-paciente :- Paciente
  [id :- s/Num, nome :- s/Str]
  {:id id, :nome nome})

(pprint (novo-paciente 15 "Guilherme"))

;erro na execução devido o schema
;(pprint (novo-paciente "15" "Guilherme"))

(defn estritamente-positivo? [x]
  (> x 0))

(def EstritamentePositivo (s/pred estritamente-positivo?))

(pprint (s/validate EstritamentePositivo 15))
;(pprint (s/validate EstritamentePositivo 0))
;(pprint (s/validate EstritamentePositivo -15))

(def Paciente
  "Schema de um paciente"
  {:id (s/constrained s/Int pos?), :nome s/Str})
(pprint (s/validate Paciente {:id 15, :nome "Guilherme"}))
;(pprint (s/validate Paciente {:id -15, :nome "Guilherme"}))