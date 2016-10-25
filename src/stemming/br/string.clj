(ns stemming.br.string
  (:require [clojure.string :as string]))

(defn exception
  [word expression replacement]
  (if (= word expression) replacement))

(defn non-pluralize
  [word sentence]
  (if (some #(= % word) sentence)
    word))

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
      (non-pluralize word ["cais" "mais"])
      (exception word "pais" "pai")
      (string/replace word #"ais$" "al") )))

(defn terminated-eis
  [word]
  (if (re-find #"[eé]is$" word)
    (let [size (count (string/replace word #"[eé]is$" ""))]
      (if (> size 2)
          (string/replace word #"[eé]is$" "el")))))


(defn terminated-ois
  [word]
  (if (re-find #"óis$" word)
    (or
      (exception word "heróis" "herói")
      (string/replace word #"óis$" "ol"))))

(defn terminated-is
  [word]
  (if (re-find #"is$" word)
    (or
      (non-pluralize word ["cais" "lápis" "mais" "crúcis" "pois" "depois" "dois"])
      (exception word "biquínis" "biquíni")
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
      (non-pluralize
        word ["cais" "aliás" "pires" "lápis" "mais" "mas" "menos" "férias" "fezes" "pêsames" "crúcis" "gás" "atrás" "moisés" "através" "convés" "ês" "país" "após" "ambas" "ambos" "messias"])
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

