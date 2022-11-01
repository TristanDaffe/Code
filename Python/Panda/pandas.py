
plt.figure(figsize=(24,12))
sns.lineplot(data=fires['Fire size'])
fires

# groupe par année, puis par états
fires['Year'] = fires['Date'].dt.year
fire_by_year = fires.groupby(['Year', 'State']).mean(['fire_size'])
fire_by_year

