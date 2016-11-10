(ns stemming.rules
  (:require [clojure.data.json :as json]))


(def ^:private PATH "./resources/orengo_stemmer_rules.json")

(def all-rules (json/read-str (slurp PATH) :key-fn keyword))

(def plural-reduction
  (let [steps (:step (stemming.rules/all-rules :rules))]
    (filter #(= (:name %) "pluralreduction") steps)))
