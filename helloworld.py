class Distribution:
    def __init__(self, good, bad, sufficient):
        self.goodMeals = good
        self.badMeals = bad
        self.sufficient = sufficient

    def __str__(self):
        return f"good meals: {self.goodMeals}, bad meals: {self.badMeals}, is this sufficient? {self.sufficient}"


class Experiment:
    badCost = 3.00  # $5.00 for a bad meal
    goodCost = 10.00  # $10.00 for a good meal
    countyCost = 7.50  # $7.50 for a county meal, we assume is good

    @staticmethod
    def totalDiet(budget, numMeals):
        good = 0
        bad = 0
        x = budget

        while (good + bad) < numMeals:
            # first, check if can afford good meal. if yes, increase good meals and subtract from budget
            if x >= Experiment.goodCost:
                good += 1
                x -= Experiment.goodCost

            # if can afford a bad meal, buy that, subtract from budget
            elif x >= Experiment.badCost:
                bad += 1
                x -= Experiment.badCost

            else:
                # if there are a nonzero number of good meals, replace a good meal with a bad meal
                if good > 0:
                    good -= 1
                    x += Experiment.goodCost
                    x -= Experiment.badCost
                    bad += 1

                # else: no more money, break
                else:
                    break

        if (good + bad) == numMeals:
            return Distribution(good, bad, True)

        # insufficient budget
        return Distribution(good, bad, False)


if __name__ == '__main__':
    # if a family has a weekly food budget of 520 to provide 11 meals, this is their distribution of good and bad
    d = Experiment.totalDiet(50, 11)
    print(str(d))