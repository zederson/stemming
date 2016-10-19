(ns stemming.br.string
  (:require [clojure.string :as string]))

(defn terminated-es
  "Substantivos terminados em -r e -z e adjetivos terminados em -s ou -z (talheres pazes)"
  [word]
  (if (re-find #"[rzs]{1}es$" word)
    (string/replace word #"es$" "")))

(defn terminated-is
  "Substantivos e adjetivos terminados em - al, -el, -ol, -ul - troca-se o -l por -is (animais tuneis)"
  [word]
  (if (re-find #"is$" word)
    (if (re-find #"[aeou]{1}is$" word)
      (string/replace word #"is$" "l")
      (string/replace word #"is$" "il"))))

(defn terminated-ns
  "Substantivos e adjetivos terminados em -m, troca-se o -m por -ns.(homens jovens)"
  [word]
  (if (re-find #"ns$" word)
    (string/replace word #"ns$" "m")))

(defn terminated-aos
  "Substantivos terminados em -ão, troca-se o -ão por -ões, -ães, -ãos."
  [word]
  (if (re-find #"[õã]{1}[eo]{1}s$" word)
    (string/replace word #"[õã]{1}[eo]{1}s$" "ão")))

(defn terminated-vowel
  "Em substantivos simples, acrescenta-se a desinência -s aos substantivos terminados em vogal"
  [word]
  (if (re-find #"[aeiou]{1}s$" word)
    (subs word 0 (->> word count dec))))

(defn grandmathers
  "casal formado por avô e avó"
  [word]
  (if (re-find #"av(ô|ó)s$" word)
    (subs word 0 (->> word count dec))

    ))



(defn singularize
  "singularize a word"
  [word]
  (let [re-word (string/lower-case word)]
    (or
      (terminated-es word)
      (terminated-is word)
      (terminated-ns word)
      (terminated-aos word)
      (terminated-vowel word)
      (grandmathers word) )))

