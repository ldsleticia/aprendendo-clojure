(ns hospitalNovo.logic
  (:require [hospitalNovo.model :as h.model]))

(defn agora []
  (h.model/to-ms (java.util.Date.)))