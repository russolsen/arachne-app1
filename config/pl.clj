(require '[arachne.core.dsl :as core])
(require '[arachne.assets.dsl :as a])

(core/runtime :test/rt [:test/output])

(core/component :test/test-transform {}
                  'arachne-demo-1/test-transformer)

(a/input-dir :test/input "rt/input")
(a/transform :test/xform :test/input :test/test-transform)
(a/output-dir :test/output :test/xform "rt/output")
