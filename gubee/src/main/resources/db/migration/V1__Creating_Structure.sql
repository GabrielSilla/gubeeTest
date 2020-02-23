CREATE TABLE config (
    id INT PRIMARY KEY AUTO_INCREMENT,
    config_key VARCHAR(50),
    config_value CHAR
);

INSERT INTO config (config_key, config_value) values ('JSON_READED', '0');

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT
);

CREATE TABLE target_market (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE stack (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE product_stack (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    stack_id INT,
    INDEX idx_product_stack_on_product_id (product_id),
    INDEX idx_product_stack_on_stack_id (stack_id),
    CONSTRAINT fk_product_stack_product FOREIGN KEY (product_id) REFERENCES product(id),
    CONSTRAINT fk_product_stack_stack FOREIGN KEY (stack_id) REFERENCES stack(id)
);

CREATE TABLE product_target_market (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    target_market_id INT,
    INDEX idx_product_target_market_on_product_id (product_id),
    INDEX idx_product_target_market_on_target_market_id (target_market_id),
    CONSTRAINT fk_product_target_market_product FOREIGN KEY (product_id) REFERENCES product(id),
    CONSTRAINT fk_product_target_market_target_market FOREIGN KEY (target_market_id) REFERENCES target_market(id)
);