package pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车页面对象，只能创建一个
 * 不需要与数据库交互，使用session完成购物车功能
 */
public class Cart {

    /**
     * key 是商品编号 id，
     * value，是商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Cart() {
    }

    /**
     * 获取该页面商品总数量
     * @return
     */
    public Integer getTotalCount() {
        Integer totalCount = 0;
        //将每个对象的书本数加起来
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    /**
     * 获取该页面商品总价格
     * @return
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        //将每个对象的书本总价格相加
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        System.out.println("进入购物车函数");
        // 先查看购物车(集合)中是否已经添加过此商品，如果已添加，将该商品数量累加，总金额更新，如果没有添加过，直接放到购物车(集合)中即可
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            // 之前没添加过此商品,将传入的商品加入购物车(集合)中
            items.put(cartItem.getId(), cartItem);
            System.out.println(items.get(cartItem.getId()).getCount());//获取count
        } else {
            // 已经 添加过的情况
            item.setCount(item.getCount()+1); // 数量 累加
            System.out.println(item.getCount());
            // 更新总金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除map中的商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 更新商品数量
     *
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        // 先查看购物车中是否有此商品。如果有，修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);// 修改商品数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount()))); // 更新总金额
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", totalPrice=" + getTotalPrice() +
                ", totalCount=" + getTotalCount() +
                '}';
    }
}
