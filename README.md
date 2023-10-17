
## Задание
Цель задания: Разработать иерархию классов для управления банковскими счетами, 
чтобы лучше понять концепцию абстрактных классов, наследования и полиморфизма.

### Задачи:

Создание абстрактного класса BankAccount:
Абстрактный класс BankAccount будет служить базовым классом для всех видов банковских счетов. 
Он должен содержать следующие характеристики:
Номер счета (accountNumber) - уникальный идентификатор счета.
Баланс (balance) - текущий остаток на счете.
Создайте конструктор для этого класса, который будет принимать номер счета и начальный баланс. 
Также определите методы для пополнения (deposit) и снятия (withdraw) денег с счета.
Создание конкретных подклассов:
Создайте классы SavingsAccount (сберегательный счет),
CheckingAccount (текущий счет) и CreditAccount (кредитный счет),
которые будут наследовать от абстрактного класса BankAccount.
Для каждого из этих классов определите уникальные характеристики и методы:
SavingsAccount может иметь поле для процентной ставки и метод для расчета процентов.
CheckingAccount может иметь лимит по чековым операциям и методы для управления ими.
CreditAccount может иметь поле для максимального кредитного лимита и метод для расчета процентов по кредиту.
Создание объектов и демонстрация использования:
Создайте несколько объектов каждого типа счетов и продемонстрируйте операции с ними.
Например, вы можете создать сберегательный счет, положить на него деньги, снять часть 
средств и произвести расчет процентов.
Покажите, как каждый вид счета работает в контексте своих уникальных характеристик.
Применение абстрактных методов:
Обязательно определите абстрактный метод для расчета процентной ставки в абстрактном классе BankAccount1.
Затем в каждом конкретном подклассе реализуйте этот метод в соответствии с правилами для данного типа счета.
