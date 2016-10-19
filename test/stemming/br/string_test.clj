(ns stemming.br.string-test
  (:require [clojure.test :refer :all]
            [stemming.br.string :refer :all]))

; http://portugues1.blogspot.com.br/2009/10/formacao-do-plural-regras-basicas.html
; resolver o problema do UTEIS
; lápis
; atlas
; ônibus
; vírus
; pires


(deftest a-singularize
  ;(testing
  ;  "substantivos simples"
  ;  (is (= "casa" (singularize "casas")))
  ;  (is (= "peru" (singularize "perus")))
  ;  (is (= "pai" (singularize "pais")))
  ;  (is (= "lei" (singularize "leis")))
  ;  (is (= "herói" (singularize "heróis")))
  ;  (is (= "réu" (singularize "réus")))
  ;  (is (= "troféu" (singularize "troféus")))
  ;  (is (= "fogaréu" (singularize "fogaréus")))
  ;  (is (= "degrau" (singularize "degraus")))
  ;  (is (= "grau" (singularize "graus")))
  ;  (is (= "sarau" (singularize "saraus")))
  ;  (is (= "bacalhau" (singularize "bacalhaus")))
  ;  (is (= "maçã" (singularize "maçãs")))
  ;  (is (= "mãe" (singularize "mães")))
  ;)

  (testing
    "A maioria dos substantivos terminados em -ão forma o plural substituindo essa terminação por -ões"
    (is (= "balão" (singularize "balões")))
    (is (= "eleição" (singularize "eleições")))
    (is (= "leão" (singularize "leões")))
    (is (= "sabichão" (singularize "sabichões")))
    (is (= "coração" (singularize "corações")))
    (is (= "vozeirão" (singularize "vozeirões")))
    (is (= "sótão" (singularize "sótãos")))
    (is (= "cidadão" (singularize "cidadãos")))
    (is (= "chão" (singularize "chãos")))
    (is (= "bênção" (singularize "bênçãos")))
    (is (= "cristão" (singularize "cristãos")))
    (is (= "grão" (singularize "grãos")))
    (is (= "órfão" (singularize "órfãos")))
    (is (= "irmão" (singularize "irmãos")))
    (is (= "mão" (singularize "mãos")))
    (is (= "alemão" (singularize "alemães")))
    (is (= "capitão" (singularize "capitães")))
    (is (= "pão" (singularize "pães")))
    (is (= "cão" (singularize "cães")))
    (is (= "charlatão" (singularize "charlatães")))
    (is (= "sacristão" (singularize "sacristães")))
    (is (= "capelão" (singularize "capelães")))
    (is (= "escrivão" (singularize "escrivães")))
    (is (= "tabelião" (singularize "tabeliães"))))

  (testing
    "Acrescenta-se a desinência -s aos substantivos terminados em -m. Essa letra é substituída por -n"
    (is (= "homem" (singularize "homens")))
    (is (= "jardim" (singularize "jardins")))
    (is (= "som" (singularize "sons")))
    (is (= "atum" (singularize "atuns"))))

  (testing
    "Os substantivos terminados em -r e -z formam o plural com o acréscimo de -es"
    (is (= "mar" (singularize "mares")))
    (is (= "açúcar" (singularize "açúcares")))
    (is (= "hambúrguer" (singularize "hambúrgueres")))
    (is (= "flor" (singularize "flores")))
    (is (= "repórter" (singularize "repórteres")))
    (is (= "revólver" (singularize "revólveres")))
    (is (= "raiz" (singularize "raizes")))
    (is (= "rapaz" (singularize "rapazes")))
    (is (= "cruz" (singularize "cruzes")))
  )

  (testing
    "Os substantivos terminados em -s formam o plural com acréscimo de -es; quando paroxítonos ou proparoxítonos, são invariáveis - o "
    ; (is (= "lápis" (singularize "lápis")))
    ; (is (= "atlas" (singularize "atlas")))
    ; (is (= "ônibus" (singularize "ônibus")))
    ; (is (= "vírus" (singularize "vírus")))
    ; (is (= "pires" (singularize "pires")))
    (is (= "gas" (singularize "gases")))
    (is (= "obus" (singularize "obuses")))
    (is (= "mes" (singularize "meses")))
    (is (= "país" (singularize "países")))
  )

  (testing
    "Os substantivos terminados em -al, -el, -ol e -ul formam o plural pela transformação do -l dessas terminações em -is"
    ; (is (= "anel" (singularize "anéis")))
    ; (is (= "igual" (singularize "iguais")))
    ; (is (= "anzol" (singularize "anzóis")))
    ; (is (= "mal" (singularize "males")))
    (is (= "álcool" (singularize "álcoois")))
    (is (= "animal" (singularize "animais")))
    (is (= "canal" (singularize "canais")))
    (is (= "vogal" (singularize "vogais")))

  )

  (testing
    "Os substantivos oxítonos terminados em -il trocam o -l pelo -s; os paroxítonos trocam essa terminação por -eis"
    ; (is (= "fóssil" (singularize "fósseis")))
    ; (is (= "projétil" (singularize "projéteis")))
    ; (is (= "réptil" (singularize "répteis")))
    ; (is (= "difícil" (singularize "difíceis")))
    (is (= "barril" (singularize "barris")))
    (is (= "ardil" (singularize "ardis")))
    (is (= "funil" (singularize "funis")))
    (is (= "fuzil" (singularize "fuzis")))
  )

  (testing
    "Os substantivos terminados em -n formam o plural pelo acréscimo de -s ou -es"
    (is (= "abdomen" (singularize "abdomens")))
    (is (= "germen" (singularize "germens")))
    (is (= "hifen" (singularize "hifens")))
    (is (= "liquen" (singularize "liquens")))
  )




)
