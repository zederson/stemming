(ns stemming.br.string-test
  (:require [clojure.test :refer :all]
            [stemming.br.string :refer :all]))

; http://portugues1.blogspot.com.br/2009/10/formacao-do-plural-regras-basicas.html
; resolver o problema do UTEIS


(deftest a-singularize
  (testing
    "substantivos simples"
    (is (= "casa" (singularize "casas")))
    (is (= "peru" (singularize "perus")))
    (is (= "pai" (singularize "pais")))
    (is (= "lei" (singularize "leis")))
    (is (= "herói" (singularize "heróis")))
    (is (= "réu" (singularize "réus")))
    (is (= "troféu" (singularize "troféus")))
    (is (= "fogaréu" (singularize "fogaréus")))
    (is (= "degrau" (singularize "degraus")))
    (is (= "grau" (singularize "graus")))
    (is (= "sarau" (singularize "saraus")))
    (is (= "bacalhau" (singularize "bacalhaus")))
    (is (= "maçã" (singularize "maçãs")))
    (is (= "mãe" (singularize "mães")))
  )

  (testing
    "A maioria dos substantivos terminados em -ão forma o plural substituindo essa terminação por -ões"
    (is (= "balão" (singularize "balões")))
    (is (= "eleição" (singularize "eleições")))
    (is (= "leão" (singularize "leões")))
    (is (= "sabichão" (singularize "sabichões")))
    (is (= "coração" (singularize "corações")))
    (is (= "vozeirão" (singularize "vozeirões"))))

)
