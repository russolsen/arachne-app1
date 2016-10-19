

(require '[arachne.core.dsl :as core])

(core/runtime :arachne-demo-1/runtime [:arachne-demo-1/ticktock])

(core/component :arachne-demo-1/ticktock {}
  'arachne-demo-1.ticktock/->TickTock)
