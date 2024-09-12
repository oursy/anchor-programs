package software.sava.anchor.programs.drift;

import java.util.function.Function;
import java.util.Arrays;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

import static software.sava.anchor.programs.drift.PerpMarketConfig.createConfig;

public final class PerpMarkets {

  public static final PerpMarketConfig[] MAIN_NET = new PerpMarketConfig[] {
      createConfig(
          "Solana",
          Set.of("Solana", "L1", "Infra"),
          "SOL-PERP",
          "SOL",
          0,
          1667560505000L,
          "BAtFj4kQttZRVep3UZS2aZRDixkGYgWsbqTBVDbnSsPF",
          "H6ARHf6YXhGYeQfUzQNGk6rDNnLBQKrenN712K4AQJEG",
          "BAtFj4kQttZRVep3UZS2aZRDixkGYgWsbqTBVDbnSsPF",
          "8UJgxaiQx5nTrdDgph5FiahMmzduuLTLf5WmsPegYA6W"
      ),
      createConfig(
          "Bitcoin",
          Set.of("Payment", "L1"),
          "BTC-PERP",
          "BTC",
          1,
          1670347281000L,
          "486kr3pmFPfTsS4aZgcsQ7kS4i9rjMsYYZup6HQNSTT4",
          "GVXRSBjFk6e6J3NbVPXohDJetcTjaeeuykUpbQF8UoMU",
          "486kr3pmFPfTsS4aZgcsQ7kS4i9rjMsYYZup6HQNSTT4",
          "2UZMvVTBQR9yWxrEdzEQzXWE61bUjqQ5VpJAGqVb3B19"
      ),
      createConfig(
          "Ethereum",
          Set.of("L1", "Infra"),
          "ETH-PERP",
          "ETH",
          2,
          1670347281000L,
          "6bEp2MiyoiiiDxcVqE8rUHQWwHirXUXtKfAEATTVqNzT",
          "JBu1AL4obBcCMqKBBxhpWCNUt136ijcuMZLFvTP7iWdB",
          "6bEp2MiyoiiiDxcVqE8rUHQWwHirXUXtKfAEATTVqNzT",
          "25Eax9W8SA3wpCQFhJEGyHhQ2NDHEshZEDzyMNtthR8D"
      ),
      createConfig(
          "Aptos",
          Set.of("L1", "Infra"),
          "APT-PERP",
          "APT",
          3,
          1675802661000L,
          "79EWaCYU9jiQN8SbvVzGFAhAncUZYp3PjNg7KxmN5cLE",
          "FNNvb1AFDnDVPkocEri8mWbJ1952HQZtFLuwPiUjSJQ",
          "79EWaCYU9jiQN8SbvVzGFAhAncUZYp3PjNg7KxmN5cLE",
          "7QAtMC3AaAc91W4XuwYXM1Mtffq9h9Z8dTxcJrKRHu1z"
      ),
      createConfig(
          "Bonk",
          Set.of("Meme", "Solana"),
          "1MBONK-PERP",
          "1MBONK",
          4,
          1677690149000L,
          "GojbSnJuPdKDT1ZuHuAM5t9oz6bxTo1xhUKpTua2F72p",
          "8ihFLu5FimgTQ1Unh4dVyEHUGodJ5gJQCrQf4KUVB9bN",
          "GojbSnJuPdKDT1ZuHuAM5t9oz6bxTo1xhUKpTua2F72p",
          "2QeqpeJUVo2LBWNELRfcBwJgrNoxJQSd7gokcaM5nvaa"
      ),
      createConfig(
          "Polygon",
          Set.of("L2", "Infra"),
          "MATIC-PERP",
          "MATIC",
          5,
          1677690149000L,
          "BrzyDgwELy4jjjsqLQpBeUxzrsueYyMhuWpYBaUYcXvi",
          "JDbuHmbAJvsBsLKSnZG8Fa9nkiQRyYfg8fGdcYwfu2u7",
          "BrzyDgwELy4jjjsqLQpBeUxzrsueYyMhuWpYBaUYcXvi",
          "6oopaUD3RK7mHBf2vPWT3aUodysg3VWcqksuAZo4xWrt"
      ),
      createConfig(
          "Arbitrum",
          Set.of("L2", "Infra"),
          "ARB-PERP",
          "ARB",
          6,
          1679501812000L,
          "8ocfAdqVRnzvfdubQaTxar4Kz5HJhNbPNmkLxswqiHUD",
          "5HRrdmghsnU3i2u5StaKaydS7eq3vnKVKwXMzCNKsc4C",
          "8ocfAdqVRnzvfdubQaTxar4Kz5HJhNbPNmkLxswqiHUD",
          "53xRgYi7591y8TKSqRbC2AMzXJF7ZLLTms6t2XKuigUp"
      ),
      createConfig(
          "Doge",
          Set.of("Meme", "Dog"),
          "DOGE-PERP",
          "DOGE",
          7,
          1680808053000L,
          "23y63pHVwKfYSCDFdiGRaGbTYWoyr8UzhUE7zukyf6gK",
          "FsSM3s38PX9K7Dn6eGzuE29S2Dsk1Sss1baytTQdCaQj",
          "23y63pHVwKfYSCDFdiGRaGbTYWoyr8UzhUE7zukyf6gK",
          "48R9ic9xgigVRqNPbABN8gTGoRV9wn6UUmcKYz3csbhR"
      ),
      createConfig(
          "Binance Coin",
          Set.of("Exchange"),
          "BNB-PERP",
          "BNB",
          8,
          1680808053000L,
          "Dk8eWjuQHMbxJAwB9Sg7pXQPH4kgbg8qZGcUrWcD9gTm",
          "4CkQJBxhU8EZ2UjhigbtdaPbpTe6mqf811fipYBFbSYN",
          "Dk8eWjuQHMbxJAwB9Sg7pXQPH4kgbg8qZGcUrWcD9gTm",
          "J6MErLoamPSkr6RzoYo8Da2WLCRmmmMQpanDSaenVCvq"
      ),
      createConfig(
          "Sui",
          Set.of("L1"),
          "SUI-PERP",
          "SUI",
          9,
          1683125906000L,
          "HBordkz5YxjzNURmKUY4vfEYFG9fZyZNeNF1VDLMoemT",
          "3Qub3HaAJaa2xNY7SUqPKd3vVwTqDfDDkEUMPjXD2c1q",
          "HBordkz5YxjzNURmKUY4vfEYFG9fZyZNeNF1VDLMoemT",
          "91NsaUmTNNdLGbYtwmoiYSn9SgWHCsZiChfMYMYZ2nQx"
      ),
      createConfig(
          "Pepe",
          Set.of("Meme"),
          "1MPEPE-PERP",
          "1MPEPE",
          10,
          1683781239000L,
          "CLxofhtzvLiErpn25wvUzpZXEqBhuZ6WMEckEraxyuGt",
          "FSfxunDmjjbDV2QxpyxFCAPKmYJHSLnLuvQXDLkMzLBm",
          "CLxofhtzvLiErpn25wvUzpZXEqBhuZ6WMEckEraxyuGt",
          "GsMte91Y1eY9XYtY1nt1Ax77V5hzsj3rr1a7a29mxHZw"
      ),
      createConfig(
          "OP",
          Set.of("L2", "Infra"),
          "OP-PERP",
          "OP",
          11,
          1686091480000L,
          "C9Zi2Y3Mt6Zt6pcFvobN3N29HcrzKujPAPBDDTDRcUa2",
          "4o4CUwzFwLqCvmA5x1G4VzoZkAhAcbiuiYyjWX1CVbY2",
          "C9Zi2Y3Mt6Zt6pcFvobN3N29HcrzKujPAPBDDTDRcUa2",
          "Aw9bzBKbryKnoLtYRLuhbhEYZHcoZyxZ5XszdepwHRKJ"
      ),
      createConfig(
          "RENDER",
          Set.of("Solana", "Infra"),
          "RENDER-PERP",
          "RENDER",
          12,
          1687201081000L,
          "8TQztfGcNjHGRusX4ejQQtPZs3Ypczt9jWF6pkgQMqUX",
          "58FU64wmcNpvC9rHcdLQRmeKsenh8rfQtA8yvkxK26Ha",
          "8TQztfGcNjHGRusX4ejQQtPZs3Ypczt9jWF6pkgQMqUX",
          "6KPv8DdWauTCV2zMqqiUbP1MjqSCDnA453VodUtZCFZR"
      ),
      createConfig(
          "XRP",
          Set.of("Payments"),
          "XRP-PERP",
          "XRP",
          13,
          1689270550000L,
          "9757epAjXWCWQH98kyK9vzgehd1XDVEf7joNHUaKk3iV",
          "Guffb8DAAxNH6kdoawYjPXTbwUhjmveh8R4LM6uEqRV1",
          "9757epAjXWCWQH98kyK9vzgehd1XDVEf7joNHUaKk3iV",
          "2fqYPht3DVWKHuEzPJy4eaCzd5onZhw7fwSxpGohexNm"
      ),
      createConfig(
          "HNT",
          Set.of("Solana", "IoT"),
          "HNT-PERP",
          "HNT",
          14,
          1692294955000L,
          "9b1rcK9RUPK2vAqwNYCYEG34gUVpS2WGs2YCZZy2X5Tb",
          "7moA1i5vQUpfDwSpK6Pw9s56ahB7WFGidtbL2ujWrVvm",
          "9b1rcK9RUPK2vAqwNYCYEG34gUVpS2WGs2YCZZy2X5Tb",
          "7jyQomwaLZYpwrcZWAa7yoDeLPTsXsCDEzhvtxeee5hY"
      ),
      createConfig(
          "INJ",
          Set.of("Exchange", "L1"),
          "INJ-PERP",
          "INJ",
          15,
          1698074659000L,
          "BfXcyDWJmYADa5eZD7gySSDd6giqgjvm7xsAhQ239SUD",
          "9EdtbaivHQYA4Nh3XzGR6DwRaoorqXYnmpfsnFhvwuVj",
          "BfXcyDWJmYADa5eZD7gySSDd6giqgjvm7xsAhQ239SUD",
          "2uBzNiiGJvJhK2iuZZKJcCZH9ih1kFroq3ZPqo9UYDUU"
      ),
      createConfig(
          "LINK",
          Set.of("Oracle"),
          "LINK-PERP",
          "LINK",
          16,
          1698074659000L,
          "Gwvob7yoLMgQRVWjScCRyQFMsgpRKrSAYisYEyjDJwEp",
          "ALdkqQDMfHNg77oCNskfX751kHys4KE7SFuZzuKaN536",
          "Gwvob7yoLMgQRVWjScCRyQFMsgpRKrSAYisYEyjDJwEp",
          "3a7HAEqxzwvJEAViYKhDtHk85mrFf1dU2HCsffgXxUj8"
      ),
      createConfig(
          "Rollbit",
          Set.of("Exchange"),
          "RLB-PERP",
          "RLB",
          17,
          1699265968000L,
          "4CyhPqyVK3UQHFWhEpk91Aw4WbBsN3JtyosXH6zjoRqG",
          "4BA3RcS4zE32WWgp49vvvre2t6nXY1W1kMyKZxeeuUey",
          "4CyhPqyVK3UQHFWhEpk91Aw4WbBsN3JtyosXH6zjoRqG",
          "CZtHZuoLWdPYZNGan5PW9P2VEnzsywgkVy1Vfe6nMN5o"
      ),
      createConfig(
          "Pyth",
          Set.of("Solana", "Oracle"),
          "PYTH-PERP",
          "PYTH",
          18,
          1700542800000L,
          "GqkCu7CbsPVz1H6W6AAHuReqbJckYG59TXz7Y5HDV7hr",
          "nrYkQQQur7z8rYTST3G9GqATviK5SxTDkrqd21MW6Ue",
          "GqkCu7CbsPVz1H6W6AAHuReqbJckYG59TXz7Y5HDV7hr",
          "75Mk3ySkJG5rCAsiQd4KZfFws35dSj2JVa6jxrqyTM52"
      ),
      createConfig(
          "Celestia",
          Set.of("Data"),
          "TIA-PERP",
          "TIA",
          19,
          1701880540000L,
          "C6LHPUrgjrgo5eNUitC8raNEdEttfoRhmqdJ3BHVBJhi",
          "funeUsHgi2QKkLdUPASRLuYkaK8JaazCEz3HikbkhVt",
          "C6LHPUrgjrgo5eNUitC8raNEdEttfoRhmqdJ3BHVBJhi",
          "H9AGF2BJe35YYgwjF8oZZogQxwBmBEy3soZWZpkVZq9e"
      ),
      createConfig(
          "Jito",
          Set.of("Solana", "MEV"),
          "JTO-PERP",
          "JTO",
          20,
          1701967240000L,
          "Ffq6ACJ17NAgaxC6ocfMzVXL3K61qxB2xHg6WUawWPfP",
          "D8UUgr8a3aR3yUeHLu7v8FWK7E8Y5sSU7qrYBXUJXBQ5",
          "Ffq6ACJ17NAgaxC6ocfMzVXL3K61qxB2xHg6WUawWPfP",
          "FH6CkSYthofVKdfuNagWn48fou1Dq5REkxhtZsk22Gpi"
      ),
      createConfig(
          "SEI",
          Set.of("L1"),
          "SEI-PERP",
          "SEI",
          21,
          1703173331000L,
          "EVyoxFo5jWpv1vV7p6KVjDWwVqtTqvrZ4JMFkieVkVsD",
          "6cUuAyAX3eXoiWkjFF77RQBEUF15AAMQ7d1hm4EPd3tv",
          "EVyoxFo5jWpv1vV7p6KVjDWwVqtTqvrZ4JMFkieVkVsD",
          "EBsU7BPiCDw7Q7GqQBzNcFGdFDU9bEmE4TjuW76fA62r"
      ),
      createConfig(
          "AVAX",
          Set.of("Rollup", "Infra"),
          "AVAX-PERP",
          "AVAX",
          22,
          1704209558000L,
          "FgBGHNex4urrBmNbSj8ntNQDGqeHcWewKtkvL6JE6dEX",
          "Ax9ujW5B9oqcv59N8m6f1BpTBq2rGeGaBcpKjC5UYsXU",
          "FgBGHNex4urrBmNbSj8ntNQDGqeHcWewKtkvL6JE6dEX",
          "CGVDM9FjRQR7e1oV8cAitnYJNZdKo7szzSSLcxhLgJEx"
      ),
      createConfig(
          "WIF",
          Set.of("Meme", "Solana", "Dog"),
          "WIF-PERP",
          "WIF",
          23,
          1706219971000L,
          "6x6KfE7nY2xoLCRSMPT1u83wQ5fpGXoKNBqFjrCwzsCQ",
          "6ABgrEZk8urs6kJ1JNdC1sspH5zKXRqxy8sg3ZG2cQps",
          "6x6KfE7nY2xoLCRSMPT1u83wQ5fpGXoKNBqFjrCwzsCQ",
          "8BbCGbxsQk1HYohgdn1TMUNs6RYcX4Hae3k8mt4rvnzf"
      ),
      createConfig(
          "JUP",
          Set.of("Exchange", "Solana", "Infra"),
          "JUP-PERP",
          "JUP",
          24,
          1706713201000L,
          "AwqRpfJ36jnSZQykyL1jYY35mhMteeEAjh7o8LveRQin",
          "g6eRCbboSwK4tSWngn773RCMexr1APQr4uA9bGZBYfo",
          "AwqRpfJ36jnSZQykyL1jYY35mhMteeEAjh7o8LveRQin",
          "8DdB5hHSZtPT3oqbsiHUytCrrodApNC31k3MuZhxJH61"
      ),
      createConfig(
          "Dymension",
          Set.of("Rollup", "Infra"),
          "DYM-PERP",
          "DYM",
          25,
          1708448765000L,
          "hnefGsC8hJi8MBajpRSkUY97wJmLoBQYXaHkz3nmw1z",
          "CSRRrhXa6DYu1W5jf89A7unCATdug2Z33tYyV2NXZZxa",
          "hnefGsC8hJi8MBajpRSkUY97wJmLoBQYXaHkz3nmw1z",
          "76k9apcvniHwHdEtWnk398ePaz8AaQfwRTH69rqxyTyc"
      ),
      createConfig(
          "BITTENSOR",
          Set.of("AI", "Infra"),
          "TAO-PERP",
          "TAO",
          26,
          1709136669000L,
          "5ZPtwR9QpBLcZQVMnVURuYBmZMu1qQrBcA9Gutc5eKN3",
          "5NxzemFgGDhimYE3S5qmb5zkjZUmiHXb4up5WGXe7NLn",
          "5ZPtwR9QpBLcZQVMnVURuYBmZMu1qQrBcA9Gutc5eKN3",
          "7rUSt1PXXn2Pp4ZNDcZqZGEgKSGpxqbRyb2W6rG1Dtt6"
      ),
      createConfig(
          "Wormhole",
          Set.of("Bridge"),
          "W-PERP",
          "W",
          27,
          1710418343000L,
          "4HbitGsdcFbtFotmYscikQFAAKJ3nYx4t7sV7fTvsk8U",
          "H9j8CT1bFiWHaZUPMooEaxMRHdWdJ5T9CzFn41z96JHW",
          "4HbitGsdcFbtFotmYscikQFAAKJ3nYx4t7sV7fTvsk8U",
          "971cCfHVRrjfBS774g27cxgZZV42k5GHTuBZ3K7sgUqh"
      ),
      createConfig(
          "Kamino",
          Set.of("Lending", "Solana"),
          "KMNO-PERP",
          "KMNO",
          28,
          1712240681000L,
          "7aqj2wH1BH8XT3QQ3MWtvt3My7RAGf5Stm3vx5fiysJz",
          "Cwrv3ghHj6oQQgWfAGXN15RYhX8ttmDx7AXwwXC3xH2F",
          "7aqj2wH1BH8XT3QQ3MWtvt3My7RAGf5Stm3vx5fiysJz",
          "HhMFv6ooJMZsDEKu8v2JER8VkHkUeEES3PZuwR6N6LMS"
      ),
      createConfig(
          "Tensor",
          Set.of("Solana", "NFT"),
          "TNSR-PERP",
          "TNSR",
          29,
          1712593532000L,
          "13jpjpVyU5hGpjsZ4HzCcmBo85wze4N8Au7U6cC3GMip",
          "Q8VX3mWPydnjA2VRFuT6QsnMzdQXJQVQGTWgwuau7si",
          "13jpjpVyU5hGpjsZ4HzCcmBo85wze4N8Au7U6cC3GMip",
          "5ep7HpgVonAeLGwWc9WeVeFjgBM2w2uFzYusm8if1ExG"
      ),
      createConfig(
          "Drift",
          Set.of("Solana", "DEX"),
          "DRIFT-PERP",
          "DRIFT",
          30,
          1716595200000L,
          "23KmX7SNikmUr2axSCy6Zer7XPBnvmVcASALnDGqBVRR",
          "7CUTyEXVdDDByR8RPDzZsFtzNYH9KKc9bEtFY4qkdY1U",
          "23KmX7SNikmUr2axSCy6Zer7XPBnvmVcASALnDGqBVRR",
          "2dCbfkVE9sa9eweSrx7ZymvfgxPEJSdHGv79mr66Kgqn"
      ),
      createConfig(
          "Sanctum",
          Set.of("Solana", "LST"),
          "CLOUD-PERP",
          "CLOUD",
          31,
          1717597648000L,
          "4FG7UyPkszGvcSVCCKaLSZsArGjyxitwhJeQhYu2bFTS",
          null,
          null,
          "2A8cqEuqEGA1bj7Jw7EJ7DjaPknxdjThsuWmia91fxkG"
      ),
      createConfig(
          "IO",
          Set.of("Solana", "DePIN"),
          "IO-PERP",
          "IO",
          32,
          1718021389000L,
          "HxM66CFwGwrvfTFFkvvA8N3CnKX6m2obzameYWDaSSdA",
          "9mq2zVYvxfUB5i3RkxpfsRMZNGB4Bv7aNe6CHqam1Y9e",
          "HxM66CFwGwrvfTFFkvvA8N3CnKX6m2obzameYWDaSSdA",
          "33c6Cz3wjwKtgBi9gykADNxGyLoXUj9qkTqVpCoF7Rjm"
      ),
      createConfig(
          "ZEX",
          Set.of("Solana", "DEX"),
          "ZEX-PERP",
          "ZEX",
          33,
          1719415157000L,
          "HVwBCaR4GEB1fHrp7xCTzbYoZXL3V8b1aek2swPrmGx3",
          "58e5mVgj8FcZhbohfV5At2XkDKtzoyvpzE1FLnBLx4zV",
          "HVwBCaR4GEB1fHrp7xCTzbYoZXL3V8b1aek2swPrmGx3",
          "2kNJMr5BnijfBAfy26QmUREYdPfXhvLs4Dxw46JkCHXx"
      ),
      createConfig(
          "POPCAT",
          Set.of("Meme", "Solana"),
          "POPCAT-PERP",
          "POPCAT",
          34,
          1720013054000L,
          "H3pn43tkNvsG5z3qzmERguSvKoyHZvvY6VPmNrJqiW5X",
          "DTuubHi6jSLeRAdEAwWA1cY1z9WRXXC5jmMF47evdjbb",
          "H3pn43tkNvsG5z3qzmERguSvKoyHZvvY6VPmNrJqiW5X",
          "2aDdPxPn7BB7spdCMM5kVxgrUnSsLtT2hyrbbYFYmcZG"
      ),
      createConfig(
          "Wen",
          Set.of("Solana", "Meme"),
          "1KWEN-PERP",
          "1KWEN",
          35,
          1720633344000L,
          "F47c7aJgYkfKXQ9gzrJaEpsNwUKHprysregTWXrtYLFp",
          "6Uo93N83iF5U9KwC8eQpogx4XptMT4wSKfje7hB1Ufko",
          "F47c7aJgYkfKXQ9gzrJaEpsNwUKHprysregTWXrtYLFp",
          "5dUgDwxmr3uibX8W9h1fDcetj1SvMawiVJfKw4zJtUuR"
      ),
      createConfig(
          "TRUMP-WIN-2024-BET",
          Set.of("Prediction", "Election"),
          "TRUMP-WIN-2024-BET",
          "TRUMP-WIN-2024",
          36,
          1723996800000L,
          "7YrQUxmxGdbk8pvns9KcL5ojbZSL2eHj62hxRqggtEUR",
          null,
          null,
          "HWQwekaW2G62QNi1eeLiNtkdxGNjaeVHktpMzpZ49RSQ"
      ),
      createConfig(
          "KAMALA-POPULAR-VOTE-2024-BET",
          Set.of("Prediction", "Election"),
          "KAMALA-POPULAR-VOTE-2024-BET",
          "KAMALA-POPULAR-VOTE-2024",
          37,
          1723996800000L,
          "AowFw1dCVjS8kngvTCoT3oshiUyL69k7P1uxqXwteWH4",
          null,
          null,
          "w6rsG6P6y56Tp5MuN2wuHK5jwmoRk9R2b3LyDoRbQBn"
      ),
      createConfig(
          "FED-CUT-50-SEPT-2024-BET",
          Set.of("Prediction", "Election"),
          "FED-CUT-50-SEPT-2024-BET",
          "FED-CUT-50-SEPT-2024",
          38,
          1724250126000L,
          "5QzgqAbEhJ1cPnLX4tSZEXezmW7sz7PPVVg2VanGi8QQ",
          null,
          null,
          "TCHmgkEZjmuGcgeHWmyEWM7y2krmVcMC8sQFKK2c2KT"
      ),
      createConfig(
          "REPUBLICAN-POPULAR-AND-WIN-BET",
          Set.of("Prediction", "Election"),
          "REPUBLICAN-POPULAR-AND-WIN-BET",
          "REPUBLICAN-POPULAR-AND-WIN",
          39,
          1724250126000L,
          "BtUUSUc9rZSzBmmKhQq4no65zHQTzMFeVYss7xcMRD53",
          null,
          null,
          "DU45iWaWQQVszZZ2738MDnymG3sDevhMXk2UYhpGvFV"
      ),
      createConfig(
          "BREAKPOINT-IGGYERIC-BET",
          Set.of("Solana", "Prediction"),
          "BREAKPOINT-IGGYERIC-BET",
          "BREAKPOINT-IGGYERIC",
          40,
          1724250126000L,
          "2ftYxoSupperd4ULxy9xyS2Az38wfAe7Lm8FCAPwjjVV",
          null,
          null,
          "88Fkp4H1pdX1Qxo3TkVG8Zw6bXStTWWEEuRtssk5UmJ9"
      ),
      createConfig(
          "DEMOCRATS-WIN-MICHIGAN-BET",
          Set.of("Prediction", "Election"),
          "DEMOCRATS-WIN-MICHIGAN-BET",
          "DEMOCRATS-WIN-MICHIGAN",
          41,
          1725551484000L,
          "8HTDLjhb2esGU5mu11v3pq3eWeFqmvKPkQNCnTTwKAyB",
          null,
          null,
          "DqYMErhg8gy1TW4w3hUe2U3Qnop4nsQCPT8y5zawVPFU"
      ),
      createConfig(
          "TON",
          Set.of("L1"),
          "TON-PERP",
          "TON",
          42,
          1725551484000L,
          "BNjCXrpEqjdBnuRy2SAUgm5Pq8B73wGFwsf6RYFJiLPY",
          "AFJXXYuniABNnoEE7DLtkxwqLDkcda4xG5k2F4FB86hj",
          "BNjCXrpEqjdBnuRy2SAUgm5Pq8B73wGFwsf6RYFJiLPY",
          "J5RWv9z5ore5pDXtyKho8fmm35N13Mststp8JRUaE93P"
      )
  };

  public static final PerpMarketConfig[] DEV_NET = new PerpMarketConfig[] {
      createConfig(
          "Solana",
          Set.of("L1", "Infra"),
          "SOL-PERP",
          "SOL",
          0,
          1655751353000L,
          "BAtFj4kQttZRVep3UZS2aZRDixkGYgWsbqTBVDbnSsPF",
          "H6ARHf6YXhGYeQfUzQNGk6rDNnLBQKrenN712K4AQJEG",
          "BAtFj4kQttZRVep3UZS2aZRDixkGYgWsbqTBVDbnSsPF",
          "8UJgxaiQx5nTrdDgph5FiahMmzduuLTLf5WmsPegYA6W"
      ),
      createConfig(
          "Bitcoin",
          Set.of("Payment", "L1"),
          "BTC-PERP",
          "BTC",
          1,
          1655751353000L,
          "486kr3pmFPfTsS4aZgcsQ7kS4i9rjMsYYZup6HQNSTT4",
          "GVXRSBjFk6e6J3NbVPXohDJetcTjaeeuykUpbQF8UoMU",
          "486kr3pmFPfTsS4aZgcsQ7kS4i9rjMsYYZup6HQNSTT4",
          "2UZMvVTBQR9yWxrEdzEQzXWE61bUjqQ5VpJAGqVb3B19"
      ),
      createConfig(
          "Ethereum",
          Set.of("L1", "Infra"),
          "ETH-PERP",
          "ETH",
          2,
          1637691133472L,
          "6bEp2MiyoiiiDxcVqE8rUHQWwHirXUXtKfAEATTVqNzT",
          "JBu1AL4obBcCMqKBBxhpWCNUt136ijcuMZLFvTP7iWdB",
          "6bEp2MiyoiiiDxcVqE8rUHQWwHirXUXtKfAEATTVqNzT",
          "25Eax9W8SA3wpCQFhJEGyHhQ2NDHEshZEDzyMNtthR8D"
      ),
      createConfig(
          "Aptos",
          Set.of("L1", "Infra"),
          "APT-PERP",
          "APT",
          3,
          1675610186000L,
          "79EWaCYU9jiQN8SbvVzGFAhAncUZYp3PjNg7KxmN5cLE",
          "FNNvb1AFDnDVPkocEri8mWbJ1952HQZtFLuwPiUjSJQ",
          "79EWaCYU9jiQN8SbvVzGFAhAncUZYp3PjNg7KxmN5cLE",
          "7QAtMC3AaAc91W4XuwYXM1Mtffq9h9Z8dTxcJrKRHu1z"
      ),
      createConfig(
          "Bonk",
          Set.of("Meme", "Dog"),
          "1MBONK-PERP",
          "1MBONK",
          4,
          1677068931000L,
          "GojbSnJuPdKDT1ZuHuAM5t9oz6bxTo1xhUKpTua2F72p",
          "8ihFLu5FimgTQ1Unh4dVyEHUGodJ5gJQCrQf4KUVB9bN",
          "GojbSnJuPdKDT1ZuHuAM5t9oz6bxTo1xhUKpTua2F72p",
          "2QeqpeJUVo2LBWNELRfcBwJgrNoxJQSd7gokcaM5nvaa"
      ),
      createConfig(
          "Polygon",
          Set.of("L2", "Infra"),
          "MATIC-PERP",
          "MATIC",
          5,
          1677690149000L,
          "BrzyDgwELy4jjjsqLQpBeUxzrsueYyMhuWpYBaUYcXvi",
          "JDbuHmbAJvsBsLKSnZG8Fa9nkiQRyYfg8fGdcYwfu2u7",
          "BrzyDgwELy4jjjsqLQpBeUxzrsueYyMhuWpYBaUYcXvi",
          "6oopaUD3RK7mHBf2vPWT3aUodysg3VWcqksuAZo4xWrt"
      ),
      createConfig(
          "Arbitrum",
          Set.of("L2", "Infra"),
          "ARB-PERP",
          "ARB",
          6,
          1679501812000L,
          "8ocfAdqVRnzvfdubQaTxar4Kz5HJhNbPNmkLxswqiHUD",
          "5HRrdmghsnU3i2u5StaKaydS7eq3vnKVKwXMzCNKsc4C",
          "8ocfAdqVRnzvfdubQaTxar4Kz5HJhNbPNmkLxswqiHUD",
          "53xRgYi7591y8TKSqRbC2AMzXJF7ZLLTms6t2XKuigUp"
      ),
      createConfig(
          "Doge",
          Set.of("Meme", "Dog"),
          "DOGE-PERP",
          "DOGE",
          7,
          1680808053000L,
          "23y63pHVwKfYSCDFdiGRaGbTYWoyr8UzhUE7zukyf6gK",
          "FsSM3s38PX9K7Dn6eGzuE29S2Dsk1Sss1baytTQdCaQj",
          "23y63pHVwKfYSCDFdiGRaGbTYWoyr8UzhUE7zukyf6gK",
          "48R9ic9xgigVRqNPbABN8gTGoRV9wn6UUmcKYz3csbhR"
      ),
      createConfig(
          "Binance Coin",
          Set.of("Exchange"),
          "BNB-PERP",
          "BNB",
          8,
          1680808053000L,
          "Dk8eWjuQHMbxJAwB9Sg7pXQPH4kgbg8qZGcUrWcD9gTm",
          "4CkQJBxhU8EZ2UjhigbtdaPbpTe6mqf811fipYBFbSYN",
          "Dk8eWjuQHMbxJAwB9Sg7pXQPH4kgbg8qZGcUrWcD9gTm",
          "J6MErLoamPSkr6RzoYo8Da2WLCRmmmMQpanDSaenVCvq"
      ),
      createConfig(
          "Sui",
          Set.of("L1"),
          "SUI-PERP",
          "SUI",
          9,
          1683125906000L,
          "HBordkz5YxjzNURmKUY4vfEYFG9fZyZNeNF1VDLMoemT",
          "3Qub3HaAJaa2xNY7SUqPKd3vVwTqDfDDkEUMPjXD2c1q",
          "HBordkz5YxjzNURmKUY4vfEYFG9fZyZNeNF1VDLMoemT",
          "91NsaUmTNNdLGbYtwmoiYSn9SgWHCsZiChfMYMYZ2nQx"
      ),
      createConfig(
          "Pepe",
          Set.of("Meme"),
          "1MPEPE-PERP",
          "1MPEPE",
          10,
          1683781239000L,
          "CLxofhtzvLiErpn25wvUzpZXEqBhuZ6WMEckEraxyuGt",
          "FSfxunDmjjbDV2QxpyxFCAPKmYJHSLnLuvQXDLkMzLBm",
          "CLxofhtzvLiErpn25wvUzpZXEqBhuZ6WMEckEraxyuGt",
          "GsMte91Y1eY9XYtY1nt1Ax77V5hzsj3rr1a7a29mxHZw"
      ),
      createConfig(
          "OP",
          Set.of("L2", "Infra"),
          "OP-PERP",
          "OP",
          11,
          1686091480000L,
          "C9Zi2Y3Mt6Zt6pcFvobN3N29HcrzKujPAPBDDTDRcUa2",
          "4o4CUwzFwLqCvmA5x1G4VzoZkAhAcbiuiYyjWX1CVbY2",
          "C9Zi2Y3Mt6Zt6pcFvobN3N29HcrzKujPAPBDDTDRcUa2",
          "Aw9bzBKbryKnoLtYRLuhbhEYZHcoZyxZ5XszdepwHRKJ"
      ),
      createConfig(
          "RENDER",
          Set.of("Infra"),
          "RENDER-PERP",
          "RENDER",
          12,
          1687201081000L,
          "8TQztfGcNjHGRusX4ejQQtPZs3Ypczt9jWF6pkgQMqUX",
          "58FU64wmcNpvC9rHcdLQRmeKsenh8rfQtA8yvkxK26Ha",
          "8TQztfGcNjHGRusX4ejQQtPZs3Ypczt9jWF6pkgQMqUX",
          "6KPv8DdWauTCV2zMqqiUbP1MjqSCDnA453VodUtZCFZR"
      ),
      createConfig(
          "XRP",
          Set.of("Payments"),
          "XRP-PERP",
          "XRP",
          13,
          1689270550000L,
          "9757epAjXWCWQH98kyK9vzgehd1XDVEf7joNHUaKk3iV",
          "Guffb8DAAxNH6kdoawYjPXTbwUhjmveh8R4LM6uEqRV1",
          "9757epAjXWCWQH98kyK9vzgehd1XDVEf7joNHUaKk3iV",
          "2fqYPht3DVWKHuEzPJy4eaCzd5onZhw7fwSxpGohexNm"
      ),
      createConfig(
          "HNT",
          Set.of("IoT"),
          "HNT-PERP",
          "HNT",
          14,
          1692294955000L,
          "9b1rcK9RUPK2vAqwNYCYEG34gUVpS2WGs2YCZZy2X5Tb",
          "7moA1i5vQUpfDwSpK6Pw9s56ahB7WFGidtbL2ujWrVvm",
          "9b1rcK9RUPK2vAqwNYCYEG34gUVpS2WGs2YCZZy2X5Tb",
          "7jyQomwaLZYpwrcZWAa7yoDeLPTsXsCDEzhvtxeee5hY"
      ),
      createConfig(
          "INJ",
          Set.of("Exchange", "L1"),
          "INJ-PERP",
          "INJ",
          15,
          1698074659000L,
          "BfXcyDWJmYADa5eZD7gySSDd6giqgjvm7xsAhQ239SUD",
          "9EdtbaivHQYA4Nh3XzGR6DwRaoorqXYnmpfsnFhvwuVj",
          "BfXcyDWJmYADa5eZD7gySSDd6giqgjvm7xsAhQ239SUD",
          "2uBzNiiGJvJhK2iuZZKJcCZH9ih1kFroq3ZPqo9UYDUU"
      ),
      createConfig(
          "LINK",
          Set.of("Oracle"),
          "LINK-PERP",
          "LINK",
          16,
          1698074659000L,
          "Gwvob7yoLMgQRVWjScCRyQFMsgpRKrSAYisYEyjDJwEp",
          "ALdkqQDMfHNg77oCNskfX751kHys4KE7SFuZzuKaN536",
          "Gwvob7yoLMgQRVWjScCRyQFMsgpRKrSAYisYEyjDJwEp",
          "3a7HAEqxzwvJEAViYKhDtHk85mrFf1dU2HCsffgXxUj8"
      ),
      createConfig(
          "Rollbit",
          Set.of("Exchange"),
          "RLB-PERP",
          "RLB",
          17,
          1699265968000L,
          "4CyhPqyVK3UQHFWhEpk91Aw4WbBsN3JtyosXH6zjoRqG",
          "4BA3RcS4zE32WWgp49vvvre2t6nXY1W1kMyKZxeeuUey",
          "4CyhPqyVK3UQHFWhEpk91Aw4WbBsN3JtyosXH6zjoRqG",
          "CZtHZuoLWdPYZNGan5PW9P2VEnzsywgkVy1Vfe6nMN5o"
      ),
      createConfig(
          "Pyth",
          Set.of("Oracle"),
          "PYTH-PERP",
          "PYTH",
          18,
          1700542800000L,
          "GqkCu7CbsPVz1H6W6AAHuReqbJckYG59TXz7Y5HDV7hr",
          "nrYkQQQur7z8rYTST3G9GqATviK5SxTDkrqd21MW6Ue",
          "GqkCu7CbsPVz1H6W6AAHuReqbJckYG59TXz7Y5HDV7hr",
          "75Mk3ySkJG5rCAsiQd4KZfFws35dSj2JVa6jxrqyTM52"
      ),
      createConfig(
          "Celestia",
          Set.of("Data"),
          "TIA-PERP",
          "TIA",
          19,
          1701880540000L,
          "C6LHPUrgjrgo5eNUitC8raNEdEttfoRhmqdJ3BHVBJhi",
          "funeUsHgi2QKkLdUPASRLuYkaK8JaazCEz3HikbkhVt",
          "C6LHPUrgjrgo5eNUitC8raNEdEttfoRhmqdJ3BHVBJhi",
          "H9AGF2BJe35YYgwjF8oZZogQxwBmBEy3soZWZpkVZq9e"
      ),
      createConfig(
          "Jito",
          Set.of("MEV"),
          "JTO-PERP",
          "JTO",
          20,
          1701967240000L,
          "Ffq6ACJ17NAgaxC6ocfMzVXL3K61qxB2xHg6WUawWPfP",
          "D8UUgr8a3aR3yUeHLu7v8FWK7E8Y5sSU7qrYBXUJXBQ5",
          "Ffq6ACJ17NAgaxC6ocfMzVXL3K61qxB2xHg6WUawWPfP",
          "FH6CkSYthofVKdfuNagWn48fou1Dq5REkxhtZsk22Gpi"
      ),
      createConfig(
          "SEI",
          Set.of("L1"),
          "SEI-PERP",
          "SEI",
          21,
          1703173331000L,
          "EVyoxFo5jWpv1vV7p6KVjDWwVqtTqvrZ4JMFkieVkVsD",
          "6cUuAyAX3eXoiWkjFF77RQBEUF15AAMQ7d1hm4EPd3tv",
          "EVyoxFo5jWpv1vV7p6KVjDWwVqtTqvrZ4JMFkieVkVsD",
          "EBsU7BPiCDw7Q7GqQBzNcFGdFDU9bEmE4TjuW76fA62r"
      ),
      createConfig(
          "AVAX",
          Set.of("Rollup", "Infra"),
          "AVAX-PERP",
          "AVAX",
          22,
          1704209558000L,
          "FgBGHNex4urrBmNbSj8ntNQDGqeHcWewKtkvL6JE6dEX",
          "Ax9ujW5B9oqcv59N8m6f1BpTBq2rGeGaBcpKjC5UYsXU",
          "FgBGHNex4urrBmNbSj8ntNQDGqeHcWewKtkvL6JE6dEX",
          "CGVDM9FjRQR7e1oV8cAitnYJNZdKo7szzSSLcxhLgJEx"
      ),
      createConfig(
          "Wormhole",
          Set.of("Bridge"),
          "W-PERP",
          "W",
          23,
          1709852537000L,
          "4iCi4DvXrubHQne8jzbMaWL3pd7v1Fip8iTe4H9vHNXB",
          "H9j8CT1bFiWHaZUPMooEaxMRHdWdJ5T9CzFn41z96JHW",
          "4HbitGsdcFbtFotmYscikQFAAKJ3nYx4t7sV7fTvsk8U",
          "8BbCGbxsQk1HYohgdn1TMUNs6RYcX4Hae3k8mt4rvnzf"
      ),
      createConfig(
          "Kamino",
          Set.of("Lending"),
          "KMNO-PERP",
          "KMNO",
          24,
          1711475936000L,
          "7aqj2wH1BH8XT3QQ3MWtvt3My7RAGf5Stm3vx5fiysJz",
          "Cwrv3ghHj6oQQgWfAGXN15RYhX8ttmDx7AXwwXC3xH2F",
          "7aqj2wH1BH8XT3QQ3MWtvt3My7RAGf5Stm3vx5fiysJz",
          "8DdB5hHSZtPT3oqbsiHUytCrrodApNC31k3MuZhxJH61"
      ),
      createConfig(
          "Wen",
          Set.of("Solana", "Meme"),
          "1KWEN-PERP",
          "1KWEN",
          25,
          1720572064000L,
          "F47c7aJgYkfKXQ9gzrJaEpsNwUKHprysregTWXrtYLFp",
          "6Uo93N83iF5U9KwC8eQpogx4XptMT4wSKfje7hB1Ufko",
          "F47c7aJgYkfKXQ9gzrJaEpsNwUKHprysregTWXrtYLFp",
          "76k9apcvniHwHdEtWnk398ePaz8AaQfwRTH69rqxyTyc"
      ),
      createConfig(
          "TRUMP-WIN-2024",
          Set.of("Prediction", "Election"),
          "TRUMP-WIN-2024-PREDICT",
          "TRUMP-WIN-2024",
          26,
          1722214583000L,
          "3TVuLmEGBRfVgrmFRtYTheczXaaoRBwcHw1yibZHSeNA",
          null,
          null,
          "7rUSt1PXXn2Pp4ZNDcZqZGEgKSGpxqbRyb2W6rG1Dtt6"
      ),
      createConfig(
          "KAMALA-POPULAR-VOTE-2024",
          Set.of("Prediction", "Election"),
          "KAMALA-POPULAR-VOTE-2024-PREDICT",
          "KAMALA-POPULAR-VOTE",
          27,
          1722214583000L,
          "GU6CA7a2KCyhpfqZNb36UAfc9uzKBM8jHjGdt245QhYX",
          null,
          null,
          "971cCfHVRrjfBS774g27cxgZZV42k5GHTuBZ3K7sgUqh"
      )
  };

  public static final Map<String, PerpMarketConfig> MAIN_NET_BY_SYMBOL = Arrays.stream(MAIN_NET)
      .collect(Collectors.toUnmodifiableMap(PerpMarketConfig::symbol, Function.identity()));

  public static final Map<String, PerpMarketConfig> DEV_NET_BY_SYMBOL = Arrays.stream(DEV_NET)
      .collect(Collectors.toUnmodifiableMap(PerpMarketConfig::symbol, Function.identity()));

  private PerpMarkets() {
  }
}