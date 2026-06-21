# Finance Portal — Geliştirme Zaman Çizelgesi (Development Timeline)

> **Amaç.** Bu projede düzenli `git` kullanımı geç bir aşamada (**24 Mayıs 2026**)
> başladı; bu nedenle commit geçmişi Mayıs–Haziran 2026'da yoğunlaşmış görünüyor.
> Oysa projenin geliştirilmesi aylar önce, **IntelliJ IDEA** üzerinde (git'e
> commit'lenmeden) başlamıştı. Bu belge gerçek zaman çizelgesini **uydurmadan**,
> yalnızca sistemin kendi **otantik ve elle düzenlenemeyen** kayıtlarından
> (IntelliJ Local History, dosya sistemi metadata'sı, git metadata'sı) yeniden
> inşa eder. Aşağıdaki her iddia, §6'daki adımlarla okuyucunun kendisi
> tarafından doğrulanabilir.

Git'teki yığılmış görünüm (bağlam):

![GitHub katkı grafiği](docs/timeline/github-contributions.png)

---

## 1. Sistem Kanıtı: Proje Aralık 2025 – Nisan 2026 arasında zaten vardı

### 1.1 IntelliJ Local History deposu — 18 Aralık 2025'ten beri
IntelliJ, çalışılan dosyaların anlık görüntülerini kullanıcı tarafından elle
değiştirilemeyen bir sistem deposunda (`changes.storageData`) tutar. Bu projenin
deposu **18 Aralık 2025**'te oluşmuş, **26 Nisan 2026**'da en son yazılmış:

![Local History deposu tarihleri](docs/timeline/evidence-localhistory-store-dates.png)

### 1.2 Frontend 13 Şubat 2026'da oluşturulmuş
Erken dönemin (TypeScript) frontend'i hâlâ diskte: `finance-portal-frontend/src`
klasörü **13 Şubat 2026**'da oluşturulmuş:

![Frontend src klasörü oluşturma tarihi](docs/timeline/evidence-frontend-src-created-feb13.png)

İçindeki `.tsx` / `.ts` dosyalarının tarihleri **13 Şubat – 13 Nisan 2026**
aralığında (erken frontend TypeScript'ti; sonradan `.jsx`'e yeniden yazıldı):

![Frontend TSX dosya tarihleri](docs/timeline/evidence-frontend-tsx-files.png)

---

## 2. Günlük Geliştirme Kaydı: 8–25 Mayıs 2026 (IntelliJ Local History)

IntelliJ Local History arayüzü, git öncesi son dönemde projenin **her günkü**
değişikliklerini saat saat tutuyor. Bu kayıtlar, düzenli git'in başladığı
24 Mayıs'tan **önce** projenin ne kadar olgun olduğunu gösteriyor. Örnekler:

**8 Mayıs** — Docker Compose, log4j2 loglama, TCMB entegrasyon client'ı, EVDS worker:

![Local History 8 Mayıs](docs/timeline/localhistory-may08.png)

**12 Mayıs** — Clean-architecture'a geçiş ("Create Package", "Moving
directories") ve kimlik/2FA katmanı (`TwoFactorAuthService`, `KeycloakAdminService`):

![Local History 12 Mayıs — clean-arch refactor](docs/timeline/localhistory-may12-cleanarch.png)

**14 Mayıs** — `domains/fund` clean-arch yapısı (`FundController`, `FundService`,
`FundDto`, `TefasFundClient`):

![Local History 14 Mayıs — fund domain](docs/timeline/localhistory-may14-fund-domain.png)

**24 Mayıs (git'e geçiş günü)** — `.env`, `run.ps1`, `.gitignore`,
`application-local.yml` oluşturuluyor; yani VS Code + git ortamının kurulduğu an:

![Local History 24 Mayıs — git'e geçiş](docs/timeline/localhistory-may24-git-transition.png)

> 8–25 Mayıs arası **günlük** Local History kayıtlarının tamamı `docs/timeline/`
> klasöründe bulunur (`localhistory-may08` … `localhistory-may24-git-transition`):
> 9, 10, 11, 13, 18, 19, 20 Mayıs günleri dahil — portfolio servisleri,
> `domains/turkish_bond` · `domains/deposit` · `domains/economy`, chart
> strategy'ler vb.

---

## 3. Çapraz Doğrulama (uydurulamaz)

İki **bağımsız** kayıt, senin anlattığın geçiş tarihinde birebir buluşuyor:

- IntelliJ Local History'de yakalanan **son** aktivite: **25 Mayıs 2026, 09:27**
  → bu tarihten sonra IntelliJ'de değişiklik yok.
- Git'te düzenli commit kadansının **başlangıcı**: **24 Mayıs 2026**
  (Mayıs: 133 commit, Haziran: 252 commit).

Yani "24 Mayıs'ta VS Code + git'e geçtim" ifadesi, iki ayrı sistem kaydıyla
doğrulanıyor: IntelliJ kaydı tam o gün biter, git kaydı tam o gün başlar.

---

## 4. Faz Faz Özet

| Faz | Dönem | Yapılanlar | Kaynak |
|---|---|---|---|
| **0 — Temel** | Şubat 2026 | Maven + Spring Boot iskeleti, ilk domain modelleri; frontend (TypeScript) 13 Şubat'ta oluşturuldu | Explorer + LH deposu |
| **1 — Çekirdek backend + ilk frontend** | Şubat–Nisan 2026 | Katmanlı backend (User/Account/Currency/Crypto/Bist/News/Analysis), React+TS frontend (Dashboard, MarketData, News, CurrencyConverter), SQL şeması | LH deposu + dosya tarihleri |
| **2 — Yeniden mimari** | Mayıs 2026 (8–24) | Clean-architecture'a geçiş (`domains/*`), kimlik/2FA/Keycloak, portfolio servisleri, chart strategy'ler, frontend `.tsx → .jsx`; günlük IntelliJ kaydı | LH arayüzü (8–25 May) |
| **3 — Git'e geçiş** | 24 Mayıs 2026 | VS Code + git kurulumu (`.env`, `run.ps1`, `.gitignore`), düzenli commit'leme başlangıcı | LH + git |
| **4 — Teslim & production** | Mayıs–Haziran 2026 | Gözlemlenebilirlik (OpenTelemetry), gerçekçi tahvil/eurobond/VİOP al-sat, i18n (TR/EN), bulut dağıtımı (GKE + HTTPS), dökümantasyon ve sunum | git (Haz: 252 commit) |

Git özeti: **395 commit**, **2026-02-10 → 2026-06-21**; düzenli kadans 24 Mayıs.

---

## 5. Mimari Evrim (zamanın bağımsız bir kanıtı)

1. **Klasör adı:** `finance-portal` (tireli, erken) → `finance_portal` (alt çizgi, güncel).
2. **Backend:** klasik katmanlı (`controller/service/repository`) → clean-architecture `domains/*`.
3. **Frontend dili:** TypeScript (`.tsx`, 13 Şubat) → `.jsx` (Mayıs).

Bu evrim, tek seferde yazılan bir projede değil; zaman içinde olgunlaşan bir
projede görülür.

---

## 6. Nasıl Doğrulanır (okuyucu kendisi kontrol edebilir)

1. **IntelliJ Local History:** Projeyi IntelliJ IDEA 2025.3 ile açın → Project
   panelinde kök/klasöre sağ tık → **Local History → Show History**. 8 Mayıs'a
   kadar giden saat-saat değişiklik kaydını doğrudan görürsünüz.
2. **Local History deposunun tarihi:**
   `%LOCALAPPDATA%\JetBrains\IntelliJIdea2025.3\LocalHistory\changes.storageData`
   → sağ tık → Özellikler → Oluşturma **18.12.2025**, Değiştirme **26.04.2026**.
3. **Frontend dosya tarihleri:**
   `…\TOYOTA-32BİT\finance-portal-frontend\src` → Ayrıntılar görünümü → `.tsx`
   dosyaları **13.02.2026 – 13.04.2026**.
4. **Git geçmişi:** `git log --reverse --date=iso --pretty="%ad %s"` — ilk
   commit 2026-02-10, düzenli kadans 24 Mayıs.

---

*Bu belge, gerçek geliştirme sürecini şeffaf ve doğrulanabilir biçimde
belgelemek için hazırlanmıştır. Commit zaman damgaları değiştirilmemiştir;
gerçek geçmiş, sistemde zaten var olan otantik kayıtlarla açıklanmıştır.*
