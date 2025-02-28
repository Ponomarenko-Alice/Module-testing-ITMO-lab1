### Задание
1. Сформировать доменную модель для заданного текста.
2. Разработать тестовое покрытие для данной доменной модели. В ходе выполнения необходимо поработать и с параметризованными тестами.
3. Написать свой JUnit5 Extension (отслеживание c последующим прерыванием слишком долгих тестов, параметр задан в файле), если extension требует дополнительной логики в тестах/предметной области - добавить ее.
4. По возможности, провести мутационное тестирование для каждого из подпунктов работы, **невозможность обосновать**.

### Текст для доменной модели  

*В рубке "Золотого Сердца" громко играла музыка: Зафод искал по суб-эфирному радио новости о себе. Ему это с трудом удавалось. Многие годы радио настраивали, нажимая кнопки и вращая рукоятки. Позже технология стала сложнее, и управление сделали сенсорным, — достаточно было касаться панелей пальцами. Теперь же нужно было просто помахивать рукой в направлении аппаратуры и надеяться, что попал. Это, конечно, экономило расход мышечной энергии, но если вы хотели слушать одну и ту же программу, то приходилось сидеть почти неподвижно.*  

*Зафод махнул рукой и канал переключился. Опять музыка, но в этот раз она была фоном для программы новостей. Новости всегда сильно редактировались, чтобы соответствовать ритму музыки.*

---

### Описание реализованной модели

Есть два типа радио - примитивное с кнопками и колесиками регулирония громкости и т.д. и современное - с дисплеем, распознающим жесты человека и реагирующее на них.

**Используется 2 паттерна:**

**1. Bridge (мост)** для возможности использоваия различного взаимодействия радио с радиоплеером, который меняет атрибуты радио (вклюсение и выключение, громкость..).
Класс плеера имеет ссылку на объект радио, которым он управляет. Плееры работают с радио через общий интерфейс. Это даёт возможность развивать плееры независимо от радио. 
Для этого достаточно создать новый подкласс абстракции. Можно создать как простой плеер с двумя кнопками, так и более сложный с тач-интерфейсом или визуальным взаимодействием.

**3. Observer (наблюдатель)** Дисплей на радио все время ожидает и пытается распознать движения человека, чтобы отреагировать. 
Поэтому подписываем класс дисплея на класс человека, который будет оповещать плеер при определенных телодвижениях человека. 

