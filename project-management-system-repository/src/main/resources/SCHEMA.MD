Таблицы представляются собой сущности из ТЗ:
•	Сотрудник
•	Проект
•	Команда
•	Задача

Employee
●	Id уникальный идентификатор, первичный ключ, автоинкремент.
●	Lastname - Фамилия (обязательное поле)
●	Name - Имя (обязательное поле)
●	Patronymic - Отчество (не обязательное)
●	Position - Должность (не обязательное)
●	Account - Учетная запись (не обязательное), уникальное
●	Email - Адрес электронной почты (не обязательное)
●	Employee_status - Статус сотрудника - (обязательное поле) фиксированный набор значений (Активный, Удаленный).

Project
●	Id - уникальный идентификатор, первичный ключ, автоинкремент.
●	Code - Код проекта - некоторое уникальное имя проекта. Является обязательным и уникальным среди всех проектов.
●	Name - Наименование - текстовое значение содержащее короткое наименование проекта.. Обязательное поле.
●	Description - Описание - текстовое значение содержащее более детальную информацию о проекте. Не обязательное поле.
●	Project_status - Статус проекта - текстовое значение, обозначающее состояние проекта. Список статусов фиксированный (Черновик, В разработке, В тестировании, Завершен). Обязательное поле.

Task
●	Id - уникальный идентификатор, первичный ключ, автоинкремент.
●	Name - Наименование задачи - текстовое значение, отражающее краткую информацию о задачи (обязательное поле).
●	Description - Описание задачи - текстовое значение, содержащее детальное описание задачи. (не обязательное поле)
●	Employee - Исполнитель задачи - сотрудник, которому необходимо исполнить задачу. (не обязательное поле).
●	Estimate - Трудозатраты - оценка, сколько в часах необходимо на ее исполнение. (обязательное поле)
●	Deadline - Крайний срок - дата, когда задача должна быть исполнена. Обязательное поле.
●	Статус задачи - фиксированный список состояний задачи (Новая, В работе, Выполнена, Закрыта). 
●	Author - Автор задачи - кто создавал задачу.
●	Create_date - Дата создания - дата когда задача была создана.
●	Change_dateДата последнего изменения задачи - дата последнего редактирования задачи (но не изменение статуса задачи).

Project_assigment
●	Id - уникальный идентификатор, первичный ключ, автоинкремент.
●	Employee_id - Идентификатор сотрудника – сотрудник в составе команды
●	Project_role - Идентификатор роли – числовое обозначение роли сотрудника в команде
●	Project_id - Идентификатор проекта – проект, на котором сотруднику назначена роль
