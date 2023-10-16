
CREATE TABLE `card_magic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `type` varchar(20) NOT NULL,
  `text` varchar(500) NOT NULL,
  `flavor` varchar(500),
  `mana_cost` varchar(20) NOT NULL,
  `mana_color` varchar(20) NOT NULL,
  `power` int,
  `toughness` int,

  PRIMARY KEY (`id`)
)


