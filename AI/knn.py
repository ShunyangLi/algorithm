import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split

"""
Pregnancies：怀孕的次数
Glucose：血浆葡萄糖浓度
BloodPressure：舒张压
SkinThickness：肱三头肌皮肤皱皱厚度
Insulin： 胰岛素
BMI：身体质量指数
dpf：糖尿病血统指数
Age：年龄
"""


if __name__ == '__main__':
	df = pd.read_csv('diabetes_data.csv')
	# 前几个数据是用来训练的
	x = df.iloc[:,0:8]
	# 相对应的结果 diabetes
	y = df.iloc[:,8]
	# 将数据集拆分为训练和测试数据

	X_train, X_test, y_train, y_test = train_test_split(x, y, test_size = 0.2, random_state=1, stratify=y)

	# 初始化knn
	knn = KNeighborsClassifier(n_neighbors = 3)

	# Fit the classifier to the data
	knn.fit(X_train,y_train)
	knn.predict(X_test)
	print(knn.score(X_test, y_test))



