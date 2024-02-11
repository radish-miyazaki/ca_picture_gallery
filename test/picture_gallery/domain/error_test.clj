(ns picture-gallery.domain.error-test
  (:require
   [clojure.spec.alpha :as s]
   [clojure.test :refer [deftest is]]
   [picture-gallery.domain.error :as domain]))

(deftest body
  (is (not (s/valid? ::domain/body {:code -1 :message "sample"})))
  (is (not (s/valid? ::domain/body {:code 1 :message nil})))
  (is (s/valid? ::domain/body {:code 1 :message "sample"})))

(deftest error
  (is (not (s/valid? ::domain/error {:status -1 :body {:code 1 :message "sample"}})))
  (is (s/valid? ::domain/error {:status 1 :body {:code 1 :message "sample"}})))

(deftest input-data-is-invalid
  (let [error (domain/input-data-is-invalid "dummy error")]
    (is (s/valid? ::domain/error error))))

