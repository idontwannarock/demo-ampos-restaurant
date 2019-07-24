INSERT INTO type (name) VALUES ('Italian'), ('Ham'), ('Pineapple'), ('Thai'), ('Chicken'), ('Mushroom'), ('Hot'), ('Chinese'), ('Pork'), ('Recommended'), ('Korean'), ('Radish'), ('Cabbage'), ('Non-alcohol'), ('Alcohol');

INSERT INTO item (name, description, image_location, price) VALUES ('Hawaiian Pizza', 'All-time favourite toppings, Hawaiian pizza in Tropical Hawaii style.', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu1.jpg', 300), ('Chicken Tom Yum Pizza', 'Best marinated chicken with pineapple and mushroom on Spicy Lemon sauce. Enjoy our tasty Thai style pizza.', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu2.jpg', 350), ('Xiaolongbao', 'Chinese steamed bun.', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu3.jpg', 200), ('Kimchi', 'Traditional side dish made from salted and fermented vegetables.', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu4.jpg', 50), ('Oolong Tea', 'Partially fermented tea grown in the Alishan area.', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu5.jpg', 30), ('Beer', 'Fantastic flavors and authentic regional appeal beer.', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu6.jpg', 60);

INSERT INTO item_types (item_id, type_id) VALUES (1, 1), (1, 2), (1, 3), (2, 1), (2, 4), (2, 5), (2, 6), (2, 7), (3, 8), (3, 9), (3, 10), (4, 11), (4, 12), (4, 13), (5, 7), (5, 14), (6, 15);

INSERT INTO menu (is_available) VALUES (1);

INSERT INTO menu_items (menu_id, item_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6);

INSERT INTO bill_order (is_checked) VALUES (0), (0), (0);

INSERT INTO order_detail (order_id, item_id, quantity, ordered_time) VALUES (1, 1, 1, '2017-01-01 10:00:00'), (1, 4, 2, '2017-01-01 10:00:00'), (1, 4, 1, '2017-01-01 11:00:00'), (2, 3, 1, '2017-01-01 12:00:00'), (2, 6, 1, '2017-01-01 12:00:00'), (3, 5, 1, '2017-01-01 15:00:00'), (3, 6, 3, '2017-01-01 15:00:00');