(ns picture-gallery.usecase.ping
  (:require
   [clojure.spec.alpha :as s]
   [picture-gallery.domain.error :as domain-error]
   [picture-gallery.domain.ping :as domain]))

(s/fdef ping
  :args (s/cat :input-model ::domain/ping-input)
  :ret (s/or :success (s/cat :ping-output ::domain/ping-output :error nil?)
             :failure (s/cat :ping-output nil? :error ::domain-error/error)))

(defn ping [input-model]
  (let [{:keys [_ comment]} input-model
        output-model (cond-> {:pong "pong"}
                       comment (assoc :comment comment))]
    [output-model nil]))

