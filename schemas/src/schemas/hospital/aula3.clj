(ns schemas.hospital.aula3
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(def Paciente
  {:id (s/pred pos-int?), :nome s/Str})

(def PosInt (s/pred pos-int?))

(s/defn novo-paciente :- Paciente
  [id :- PosInt
   nome :- s/Str]
  {:id id, :nome nome})

;(pprint (novo-paciente 15, "Guilherme"))

(defn maior-ou-igual-a-zero [x] (>= x 0))
(def ValorFinanceiro (s/constrained s/Num maior-ou-igual-a-zero))

(def Pedido
  {:paciente      Paciente
   :valor         ValorFinanceiro
   :procedimento  s/Keyword})

(s/defn novo-pedido :- Pedido
  [paciente :- Paciente, valor :- ValorFinanceiro, procedimento :- s/Keyword]
  {:paciente paciente, :valor valor, :procedimento procedimento})

(pprint (novo-pedido (novo-paciente 15, "Guilherme") 15.53, :raio-x))


(def Numeros [s/Num])
(pprint (s/validate Numeros [15]))

(def Plano [s/Keyword])
(pprint (s/validate Plano [:raio-x]))

(def Paciente
  {:id PosInt, :nome s/Str, :plano Plano})

(pprint (s/validate Paciente {:id 15, :nome "Guilherme", :plano [:raio-x, :ultrassom]}))
(pprint (s/validate Paciente {:id 15, :nome "Guilherme", :plano [:raio-x]}))
(pprint (s/validate Paciente {:id 15, :nome "Guilherme", :plano []}))
(pprint (s/validate Paciente {:id 15, :nome "Guilherme", :plano nil}))