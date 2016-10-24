(ns stemming.br.string
  (:require [clojure.string :as string]))

(defn exception
  [word expression replacement]
  (if (= word expression) replacement))

(defn terminated-ns
  [word]
  (if (re-find #"ns$" word)
    (string/replace word #"ns$" "m")))

(defn terminated-oes
  [word]
  (if (re-find #"ões$" word)
    (string/replace word #"ões$" "ão")))

(defn terminated-aes
  [word]
  (if (re-find #"ães$" word)
    (or
      (exception word "mães" "mãe")
      (string/replace word #"ães$" "ão") )))

(defn terminated-ais
  [word]
  (if (re-find #"ais$" word)
    (or
      (exception word "cais" "cais")
      (exception word "mais" "mais")
      (string/replace word #"ais$" "al") )))

(defn terminated-eis
  [word]
  (if (re-find #"[eé]is$" word)
    (string/replace word #"[eé]is$" "el")))

(defn terminated-ois
  [word]
  (if (re-find #"óis$" word)
    (string/replace word #"óis$" "ol")))

(defn terminated-is
  [word]
  (if (re-find #"is$" word)
    (or
      (exception word "cais" "cais")
      (exception word "lápis" "lápis")
      (exception word "mais" "mais")
      (exception word "crúcis" "crúcis")
      (exception word "biquínis" "biquíni")
      (exception word "pois" "pois")
      (exception word "depois" "depois")
      (exception word "dois" "dois")
      (exception word "leis" "lei")
      (if (re-find #"[aeou]{1}is$" word)
        (string/replace word #"is$" "l")
        (string/replace word #"is$" "il")) )))

(defn terminated-les
  [word]
  (if (re-find #"les$" word)
    (string/replace word #"les$" "l")))

(defn terminated-res
  [word]
  (if (re-find #"res$" word)
    (string/replace word #"res$" "r")))

(defn terminated-es
  [word]
  (if (re-find #"[rzs]{1}es$" word)
    (string/replace word #"es$" "")))

(defn terminated-s
  [word]
  (if (re-find #"s$" word)
    (or
      (exception word "cais" "cais")
      (exception word "aliás" "aliás")
      (exception word "pires" "pires")
      (exception word "lápis" "lápis")
      (exception word "mais" "mais")
      (exception word "mas" "mas")
      (exception word "menos" "menos")
      (exception word "férias" "férias")
      (exception word "fezes" "fezes")
      (exception word "pêsames" "pêsames")
      (exception word "crúcis" "crúcis")
      (exception word "gás" "gás")
      (exception word "atrás" "atrás")
      (exception word "moisés" "moisés")
      (exception word "através" "através")
      (exception word "convés" "convés")
      (exception word "ês" "ês")
      (exception word "país" "país")
      (exception word "após" "após")
      (exception word "ambas" "ambas")
      (exception word "ambos" "ambos")
      (exception word "messias" "messias")
      (subs word 0 (->> word count dec))
 )))

(defn singularize
  "singularize a word"
  [word]
  (let [re-word (string/lower-case word)]
    (or
      (terminated-ns re-word)
      (terminated-oes re-word)
      (terminated-aes re-word)
      (terminated-ais re-word)
      (terminated-eis re-word)
      (terminated-ois re-word)
      (terminated-is re-word)
      (terminated-les re-word)
      (terminated-res re-word)
      (terminated-es re-word)
      (terminated-s re-word)
    )
  )
)

