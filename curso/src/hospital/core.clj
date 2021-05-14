(ns hospital.core
  (:use [clojure pprint])
  (:require[hospital.model :as h.model]))

(let [hospital-da-lety (h.model/novo-hospital)] (pprint hospital-da-lety))

(pprint h.model/fila-vazia)