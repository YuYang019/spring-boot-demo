# spring boot demo

用spring boot做的一个商品下单程序，仅提供rest api，模拟最普遍的前后端分离的开发模式

## 表的设计

```mysql
create table `product_info` (
  `product_id` varchar(32) not null,
  `product_name` varchar(64) not null comment '商品名称',
  `product_price` decimal(8, 2) not null comment '单价',
  `product_stock` int not null comment '库存',
  `product_description` varchar(64) comment '描述',
  `product_icon` varchar(512) comment '小图',
  `category_type` int not null comment '类目编号',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`product_id`)
) comment '商品表';

create table `product_category` (
  `category_id` int not null auto_increment,
  `category_name` varchar(64) not null comment '类目名字',
  `category_type` int not null comment '类目编号',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`category_id`),
  unique key `uqe_category_type` (`category_type`)
) comment '类目表';

create table `order_master` (
  `order_id` varchar(32) not null,
  `buyer_name` varchar(32) not null comment '买家名字',
  `buyer_phone` varchar(32) not null comment '买家电话',
  `buyer_address` varchar(128) not null comment '买家地址',
  `buyer_openid` varchar(64) not null comment '买家微信openid',
  `order_amount` decimal(8, 2) not null comment '订单总金额',
  `order_status` tinyint(3) not null default '0' comment '订单状态, 默认0新下单',
  `pay_status` tinyint(3) not null default '0' comment '支付状态，默认0未支付',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`order_id`),
  key `idx_buyer_openid` (`buyer_openid`)
) comment '订单主表';

create table `order_detail` (
  `detail_id` varchar(32) not null,
  `order_id` varchar(32) not null,
  `product_id` varchar(32) not null,
  `product_name` varchar(64) not null comment '商品名称',
  `product_price` decimal(8, 2) not null comment '商品价格',
  `product_quantity` int not null comment '商品数量',
  `product_icon` varchar(512) comment '商品小图',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`detail_id`),
  key `idx_order_id` (`order_id`)
) comment '订单详情表';
```

## API 设计（未完成）

### GET  /sell/product/list  商品列表

返回格式

```
{
     code: 0,
     msg: "成功",
     data: [
        {
            name: "热榜",
            type: 1,
            foods: [
                {
                    id: "123456",
                    name: "皮蛋粥",
                    price: 1.12,
                    description: "好吃",
                    icon: "http://www.icon.com"
                }
            ]
        }
     ]
}
```

### POST  /sell/buyer/order/create 创建订单

参数
```
name: "张三"
phone: "1232838212"
address: "北京"
openid: "124123123"
items: [{
    productId: "12312321",
    productQuantity: 2
}]
```

返回格式

```
{
    code: 0,
    msg: "成功",
    data: {
        orderId: "1121312413"
    }
}
```



