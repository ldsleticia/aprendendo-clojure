(ns hospitalNovo.aula1
  (:use [clojure pprint]))

(defn adicona-paciente
  [pacientes paciente]
  (if-let [id (:id paciente)]
      (assoc pacientes (:id paciente) paciente)
      (throw (ex-info "Paciente não possui id" {:paciente paciente}))))

(defn testa-uso-de-pacientes []
  (let [pacientes {}
        guilherme {:id 15 :nome "guilherme" :nascimento "18/09/1981"}
        daniela {:id 16 :nome "daniela" :nascimento "18/09/1982"}
        paulo {:id 15 :nome "paulo" :nascimento "18/09/1983"}]
    (pprint (adicona-paciente pacientes guilherme))
    (pprint (adicona-paciente pacientes daniela))
    (pprint (adicona-paciente pacientes paulo))))

;(testa-uso-de-pacientes)

(defrecord Paciente [id ^String nome nascimento])

(pprint (->Paciente 15 "Guilherme" "18/09/1981"));não permite sem parametro
(pprint (Paciente. 15 "Guilherme" "18/09/1981"));não permite sem parametro
(pprint (map->Paciente {:id 15, :nome "Guilherme", :nascimento "18/09/1981"}))

(let [guilherme (->Paciente 15 "Guilherme" "18/09/1981")]
  (pprint (:id guilherme)))
  (pprint (vals guilherme))

(pprint (map->Paciente {:id 15, :nome "Guilherme", :nascimento "18/09/1981" :rg "222222"})) ;permite sem parâmetro
(pprint (map->Paciente {:nome "Guilherme", :nascimento "18/09/1981" :rg "222222"})) ;permite sem parâmetro