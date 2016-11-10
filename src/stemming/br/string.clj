(ns stemming.br.string
  (:require [clojure.string :as string]
            [stemming.rules :as config]))

(def rules
  (map :rule config/plural-reduction))

(defn apply-replacement
  [word rule]

  (println (:replacement rule) rule)

)

(defn valid?
  [word rule]
  (re-find (re-pattern (str (:suffix rule) "$")) word)
)

(defn apply-plural-reduction
  [word]
  (map (fn[rule] (apply-replacement word rule))
    (filter (fn[rule] (valid? word rule)) (first stemming.br.string/rules)))
)

(defn singularize
  "singularize a word"
  [word]
  (let [re-word (string/lower-case word)]
    (apply-plural-reduction re-word)
  )
)

