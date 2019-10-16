package com.nv;

/**
 * Класс для работы с комплексными числами
 */
class TComplex {
    /**
     * Действительная часть числа
     */
    private double re;

    /**
     * Мнимая часть числа
     */
    private double im;

    /**
     * Конструктор
     * @param re {double} действительная часть
     * @param im {double} мнимая часть
     */
    TComplex(double re, double im){
        this.re = re;
        this.im = im;
    }

    /**
     * Функция возвращает значение действительной части
     * @return {double}
     */
    private double getRe() {
        return this.re;
    }

    /**
     * Функция возвращает значение мнимой части
     *
     * @return {double}
     */
    private double getIm() {
        return this.im;
    }

    /**
     * Функция возвращает сумму комплексных чисел
     * @param a {TComplex}
     * @param b {TComplex}
     * @return {TComplex}
     */
    public static TComplex sum(TComplex a, TComplex b){
        return new TComplex(a.re + b.re, a.im + b.im);
    }

    /**
     * Функция возвращает разность комплексных чисел
     * @param a {TComplex}
     * @param b {TComplex}
     * @return {TComplex}
     */
    public static TComplex sub(TComplex a, TComplex b){
        return new TComplex(a.re - b.re, a.im - b.im);
    }

    /**
     * Функция возвращает модуль комплексного числа
     * @return {double}
     */
    public double getModule(){
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }

    /**
     * Функция возвращает произведение комплексных чисел
     * @param a {TComplex}
     * @param b {TComplex}
     * @return {TComplex}
     */
    public static TComplex mul(TComplex a, TComplex b){
        return new TComplex(a.getRe() * b.getRe() - a.getIm() * b.getIm(),a.getRe() * b.getIm() + a.getIm()*b.getRe());
    }

    /**
     * Функция возвращает частное двух комплексных чисел
     * @param a {TComplex} первое число
     * @param b {TComplex}  второе число
     * @return {TComplex}
     */
    public static TComplex divide(TComplex a, TComplex b){
        TComplex temp = new TComplex(b.getRe(), (-1) * b.getIm());
        temp = TComplex.mul(a, temp);
        double denominator = Math.pow(b.getRe(), 2) + Math.pow(b.getIm(), 2);
        return new TComplex(temp.getRe() / denominator, temp.getIm() / denominator);
    }

    /**
     * Функция возвращает корень из комплексного числа
     * @return {Array}
     */
    public TComplex[] sqrt(){
        TComplex _a = new TComplex(this.getRe(), this.getIm());

        double sqrtMod = Math.sqrt(_a.getModule());
        double arg = _a.getArg();

        TComplex pos = new TComplex(sqrtMod * Math.cos(arg/2),sqrtMod * Math.sin(arg/2));
        TComplex neg = new TComplex(sqrtMod * Math.cos((arg + 2 * Math.PI) / 2), sqrtMod * Math.sin((arg + 2 * Math.PI) / 2));

        TComplex[] answer = {pos, neg};

        return answer;
    }

    /**
     * Определяет знак при мнимой части числа
     * Добавила обработку случая, когда мнимая часть равна нулю
     * @return {String | null}
     */
    private String sign(){
        if (this.im > 0) return "+";
        if(this.im < 0) return "-";
        return null;
    }

    /**
     * Функция возвращает аргумент комплексного числа
     * @return {double}
     */
    public double getArg(){

        if(this.re > 0){
            return Math.atan(this.im / this.re);
        }

        if(this.re < 0 && this.im > 0){
            return Math.PI + Math.atan(this.im / this.re);
        }

        return -Math.PI + Math.atan(this.im / this.re);
    }

    @Override
    public String toString(){

        String _re = "", _im = "";

        if(this.im == 1 || this.im == -1){
            _im = this.sign() + "i";
        } else if(this.im != 0){
            _im = this.sign() + Math.abs(this.im) + "i";
        }

        if(this.re != 0){
            _re += this.re;
        }

        return _re + _im;
    }
}
