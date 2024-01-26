(defproject picture-gallery "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [integrant "0.8.1"]
                 [integrant/repl "0.3.3"]
                 [ring/ring-jetty-adapter "1.11.0"]
                 [com.fasterxml.jackson.core/jackson-core "2.16.1"]
                 [ring-cors "0.1.13"]
                 [ring-logger "1.1.1"]
                 [metosin/reitit "0.7.0-alpha7"]
                 [metosin/reitit-swagger "0.7.0-alpha7"]
                 [metosin/reitit-swagger-ui "0.7.0-alpha7"]
                 [buddy/buddy-hashers "2.0.167"]
                 [environ "1.2.0"]
                 [com.taoensso/timbre "6.3.1"]
                 [com.fzakaria/slf4j-timbre "0.4.1"]
                 [honeysql "1.0.461"]
                 [seancorfield/next.jdbc "1.2.659"]
                 [hikari-cp "3.0.1"]
                 [org.postgresql/postgresql "42.7.1"]
                 [net.ttddyy/datasource-proxy "1.10"]
                 [com.google.firebase/firebase-admin "9.2.0"]
                 [ragtime "0.8.1"]
                 [orchestra "2021.01.01-1"]
                 [org.clojure/test.check "1.1.1"]
                 [org.clojure/tools.cli "1.0.219"]
                 [clj-time "0.15.2"]
                 [cheshire "5.12.0"]
                 [camel-snake-kebab "0.4.3"]]
  :main ^:skip-aot picture-gallery.core
  :target-path "target/%s"
  :profiles {:dev [:project/dev :profiles/dev]
             :repl {:prep-tasks ^:replace ["javac" "compile"]
                    :repl-options {:init-ns user}}
             :project/dev {:source-paths ["dev/src"]
                           :resource-paths ["dev/resources"]}
             :profiles/dev {}
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})

