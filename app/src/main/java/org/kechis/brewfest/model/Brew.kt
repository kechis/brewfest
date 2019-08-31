package org.kechis.brewfest.model

data class Brew (var id: Int, var name: String, var description: String, var abv: Double)
//{
//    "id": 18,
//    "name": "Russian Doll – India Pale Ale",
//    "tagline": "Nesting Hop Bomb.",
//    "first_brewed": "08/2014",
//    "description": "The levels of hops vary throughout the range. We love hops, so all four beers are big, bitter badasses, but by tweaking the amount of each hop used later in the boil and during dry- hopping, we can balance the malty backbone with some unexpected flavours. Simcoe is used in the whirlpool for all four beers, and yet still lends different characters to each",
//    "image_url": "https://images.punkapi.com/v2/18.png",
//    "abv": 6,
//    "ibu": 70,
//    "target_fg": 1012,
//    "target_og": 1058,
//    "ebc": 25,
//    "srm": 12.5,
//    "ph": 5.2,
//    "attenuation_level": 79.3,
//    "volume": {
//    "value": 20,
//    "unit": "liters"
//},
//    "boil_volume": {
//    "value": 25,
//    "unit": "liters"
//},
//    "method": {
//    "mash_temp": [
//    {
//        "temp": {
//        "value": 65,
//        "unit": "celsius"
//    },
//        "duration": 75
//    }
//    ],
//    "fermentation": {
//    "temp": {
//    "value": 19,
//    "unit": "celsius"
//}
//},
//    "twist": null
//},
//    "ingredients": {
//    "malt": [
//    {
//        "name": "Extra Pale",
//        "amount": {
//        "value": 5.06,
//        "unit": "kilograms"
//    }
//    },
//    {
//        "name": "Caramalt",
//        "amount": {
//        "value": 0.25,
//        "unit": "kilograms"
//    }
//    },
//    {
//        "name": "Dark Crystal",
//        "amount": {
//        "value": 0.06,
//        "unit": "kilograms"
//    }
//    }
//    ],
//    "hops": [
//    {
//        "name": "Cascade",
//        "amount": {
//        "value": 2.5,
//        "unit": "grams"
//    },
//        "add": "start",
//        "attribute": "bitter"
//    },
//    {
//        "name": "Centennial",
//        "amount": {
//        "value": 12.5,
//        "unit": "grams"
//    },
//        "add": "middle",
//        "attribute": "flavour"
//    },
//    {
//        "name": "Simcoe",
//        "amount": {
//        "value": 17.5,
//        "unit": "grams"
//    },
//        "add": "middle",
//        "attribute": "flavour"
//    },
//    {
//        "name": "Simcoe",
//        "amount": {
//        "value": 17.5,
//        "unit": "grams"
//    },
//        "add": "end",
//        "attribute": "flavour"
//    },
//    {
//        "name": "Citra",
//        "amount": {
//        "value": 17.5,
//        "unit": "grams"
//    },
//        "add": "end",
//        "attribute": "flavour"
//    },
//    {
//        "name": "Simcoe",
//        "amount": {
//        "value": 75,
//        "unit": "grams"
//    },
//        "add": "dry hop",
//        "attribute": "aroma"
//    },
//    {
//        "name": "Cascade",
//        "amount": {
//        "value": 75,
//        "unit": "grams"
//    },
//        "add": "dry hop",
//        "attribute": "aroma"
//    },
//    {
//        "name": "Centennial",
//        "amount": {
//        "value": 75,
//        "unit": "grams"
//    },
//        "add": "dry hop",
//        "attribute": "aroma"
//    },
//    {
//        "name": "Citra",
//        "amount": {
//        "value": 25,
//        "unit": "grams"
//    },
//        "add": "dry hop",
//        "attribute": "aroma"
//    }
//    ],
//    "yeast": "Wyeast 1056 - American Ale™"
//},
//    "food_pairing": [
//    "Spicy chicken skewers",
//    "Fish tacos with hot sauce",
//    "Lemon pound cake with a ice sugar glaze"
//    ],
//    "brewers_tips": "Create balance through experimentation with the hop amounts and malt backbone.",
//    "contributed_by": "Sam Mason <samjbmason>"
//}