(ns loja.logic)

 (defn resumo-por-usuario [pedidos]
   (->> pedidos
   (group-by :usuario)
   (map quantia-de-pedidos-e-gasto-total-por-usuario)))