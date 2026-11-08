# Naloga 5 – Delo z različnimi aktivnostmi

Razvoj mobilnih aplikacij – Naloga 5

Android aplikacija (Java) s tremi aktivnostmi, ki si med seboj podajajo vrednost števca z eksplicitnimi nameni (`Intent`).

## Opis

| Aktivnost | Vsebina |
|---|---|
| **MainActivity** | Rumen zaslon z gumbom **Count**, ki povečuje števec, in gumboma za prehod v drugo in tretjo aktivnost. |
| **HelloActivity** | Moder zaslon z napisom **Hello!**, trenutno vrednostjo števca in gumbom za vrnitev na prvo aktivnost. |
| **ThirdActivity** | Oranžen zaslon z napisom **Activity 3**, trenutno vrednostjo števca in gumboma za prehod na prvo ali drugo aktivnost. Prehod deluje tudi s potegom prsta. |

## Funkcionalnosti

- Povečevanje števca na glavnem zaslonu; vrednost se ohrani tudi ob obratu zaslona (`onSaveInstanceState`).
- Prenos števca med aktivnostmi s `putExtra()` in `getIntExtra()`.
- Vrnitev na obstoječo `MainActivity` z zastavicama `FLAG_ACTIVITY_CLEAR_TOP` in `FLAG_ACTIVITY_SINGLE_TOP`, zato se števec ne ponastavi in se ne kopičijo novi primerki aktivnosti.
- Potezna navigacija v `ThirdActivity` z razredom `OnSwipeTouchListener`:
  - poteg **v levo** → `MainActivity`
  - poteg **v desno** → `HelloActivity`
- Naslovna vrstica (action bar) z napisom *Activities - example* prek teme `Theme.MaterialComponents.DayNight.DarkActionBar`.

## Struktura

```
app/src/main/
├── java/com/example/activities/
│   ├── MainActivity.java          # števec in prehodi v 2. in 3. aktivnost
│   ├── HelloActivity.java         # prikaz "Hello!" in števca
│   ├── ThirdActivity.java         # prikaz števca, gumbi in poteze
│   ├── OnSwipeTouchListener.java  # zaznavanje potega levo/desno
│   └── InsetsUtil.java            # odmik od sistemskih vrstic (edge-to-edge)
├── res/layout/
│   ├── activity_main.xml
│   ├── activity_hello.xml
│   └── activity_third.xml
└── AndroidManifest.xml
```

## Vprašanja

1. **Kateri menijski ukaz v Android Studiu uporabite za dodajanje nove aktivnosti?**
   *File → New → Activity → Empty Views Activity* (ali desni klik na paket → *New → Activity*).

2. **Katere datoteke se dodajo ob novi aktivnosti HelloActivity in katera se posodobi?**
   Dodata se `HelloActivity.java` in `res/layout/activity_hello.xml`, posodobi pa se `AndroidManifest.xml` (nov vnos `<activity>`).

3. **Kateri konstruktor ustvari eksplicitni namen?**
   b) `new Intent(Context context, Class<?> class)`

4. **Kako dodate vrednost števca v namen?**
   c) kot dodaten podatek namena (`putExtra()`)

5. **S katero metodo v MainActivity zaženete HelloActivity?**
   c) `showToast(View view)` – v originalnem primeru (Hello Toast) ta metoda zažene drugo aktivnost; v tej aplikaciji se ista naloga izvede v metodi `goToHello(View view)`.

6. **Kako v HelloActivity posodobite prikaz števca?**
   d) Vse navedeno – pridobite namen (`getIntent()`), iz njega preberete vrednost (`getIntExtra()`) in posodobite `TextView`.

7. **Kateri zapis omogoča vrnitev na MainActivity brez novih primerkov?**
   b) `Intent.FLAG_ACTIVITY_CLEAR_TOP` in `Intent.FLAG_ACTIVITY_SINGLE_TOP`

8. **Kaj je glavna vloga ThirdActivity?**
   c) prikaz prenesenega števca in omogočanje dodatne navigacije med aktivnostmi
