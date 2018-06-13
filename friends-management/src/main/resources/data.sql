insert into friends(id, email)
values
	(1, 'abc@gmail.com'),
	(2, 'def@gmail.com'),
	(3, 'pqr@gmail.com'),
	(4, 'mnp@gmail.com'),
	(5, 'qrs@gmail.com'),
	(6, 'xyz@gmail.com');
	
	
insert into connections(id, p_id, f_id, block)
values
	(1, 1, 2, false),
	(2, 1, 2, false),
	(3, 1, 3, false),
	(4, 2, 4, false),
	(5, 2, 5, false),
	(6, 2, 3, false),
	(7, 3, 1, false),
	(8, 3, 2, false);
	
	
insert into subscriptions(id, p_id, f_id, subscribed)
values
	(1, 1, 2, true),
	(2, 1, 2, true),
	(3, 1, 3, false),
	(4, 2, 4, true),
	(5, 2, 5, true),
	(6, 2, 3, false),
	(7, 3, 1, false),
	(8, 3, 2, true);