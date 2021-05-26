(ns testes.hospital.logic-test
  (:require [clojure.test :refer :all]
            [testes.hospital.logic :refer :all]
            [testes.hospital.model :refer :all]))

(deftest cabe-na-fila?-test
  (testing "Que cabe na fila"
    ;boundary tests
    ;exatamente a borda e one off, -1 +1 <= >= =

    ;bordd do zero
    (is (cabe-na-fila? {:espera []}, :espera)))

  ;borda do = (limite)
  (testing "Que não cabe na fila quando a fila está cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5]}, :espera))))

  ;borda do +1 (limite pra cima)
  (testing "Que não cabe na fila tem mais do que a fila cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5 6]}, :espera))))

  ;borda -1
  (testing "Que cabe na fila tem menos do que a fila cheia"
    (is (cabe-na-fila? {:espera [1 2 3 4]}, :espera)))

  (testing "Que cabe na fila tem pouca gente"
    (is (cabe-na-fila? {:espera [1 2 32]}, :espera)))

  (testing "Departamento não existe"
    (is (not (cabe-na-fila? {:espera [1 2 3 4]}, :raio-x)))))

(deftest chega-em-test
  (testing "não aceita quando não cabe na fila"
        (is (thrown? clojure.lang.ExceptionInfo "não cabe ninguém neste departamento."
            (chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)))))

    ;    (is (thrown? IllegalStateException
    ;        (chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)))

    ;    (is (nil? (chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)))

    ;(is ((try
    ;       (chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)
    ;       false
    ;       (catch clojure.lang.ExceptionInfo e
    ;         (= :impossivel-colocar-pessoa-na-fila (:tipo 9ex-data e))))
    ;     ))))

(deftest transfere-test
  (testing "aceita pessoas se cabe"
    (let [hospital-original {:espera (conj testes.hospital.model/fila-vazia 51 5), :raio-x (conj testes.hospital.model/fila-vazia 13)}]
      (is (= {:espera [5]
              :raio-x [13 51]}
             (transfere hospital-original :espera :raio-x)))))
  (testing "recusa pessoas se não cabe"
    (let [hospital-cheio {:espera [5], :raio-x [1 2 53 42 13]}]
      (is (thrown? clojure.lang.ExceptionInfo
                   (transfere hospital-cheio :espera :raio-x))))))