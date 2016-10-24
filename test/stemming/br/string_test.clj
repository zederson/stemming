(ns stemming.br.string-test
  (:require [clojure.test :refer :all]
            [stemming.br.string :refer :all]))

; http://portugues1.blogspot.com.br/2009/10/formacao-do-plural-regras-basicas.html
; https://03021846268424808119.googlegroups.com/attach/5a956b0c29e9a766/steprules.txt?part=0.2&view=1&vt=ANaJVrGl0XPNBlhygp3WEXMrAFfeEhccPxyq9bNe19KsSMmXk4mm_pVbpoAyFMyogcPgicCnsgFSrd5N8gLatjwo2H5Y-V3mYx4v9eyQtXxZaNbYDprBO0c
; resolver o problema do UTEIS
; lápis
; atlas
; ônibus
; vírus
; pires


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

  ;(testing
  ;  "Os substantivos terminados em -n formam o plural pelo acréscimo de -s ou -es"
  ;  (is (= "abdomen" (singularize "abdomens")))
  ;  (is (= "germen" (singularize "germens")))
  ;  (is (= "hifen" (singularize "hifens")))
  ;  (is (= "liquen" (singularize "liquens")))
  ;)


  (testing
    "Nesses casos, ocorre um fenômeno chamado metafonia, ou seja, a mudança de som entre uma forma e outra"
    (is (= "aposto" (singularize "apostos")))
    (is (= "caroço" (singularize "caroços")))
    (is (= "corno" (singularize "cornos")))
    (is (= "corpo" (singularize "corpos")))
    (is (= "corvo" (singularize "corvos")))
    (is (= "esforço" (singularize "esforços")))
    (is (= "fogo" (singularize "fogos")))
    (is (= "imposto" (singularize "impostos")))
    (is (= "miolo" (singularize "miolos")))
    (is (= "osso" (singularize "ossos")))
    (is (= "poço" (singularize "poços")))
    (is (= "porto" (singularize "portos")))
    (is (= "povo" (singularize "povos")))
    (is (= "socorro" (singularize "socorros")))
    (is (= "forno" (singularize "fornos")))
    (is (= "jogo" (singularize "jogos")))
    (is (= "olho" (singularize "olhos")))
    (is (= "ovo" (singularize "ovos")))
    (is (= "porco" (singularize "porcos")))
    (is (= "posto" (singularize "postos")))
    (is (= "reforço" (singularize "reforços")))
    (is (= "tijolo" (singularize "tijolos"))))





)
