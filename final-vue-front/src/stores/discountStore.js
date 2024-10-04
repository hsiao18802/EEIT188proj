import { defineStore } from 'pinia'
import axiosapi from '@/plugins/axios'

export const useDiscountStore = defineStore('discountStore', {
  state: () => ({
    discounts: []
  }),
  actions: {
    async fetchDiscounts() {
      try {
        const response = await axiosapi.get('/rent/discount/all')
        this.discounts = response.data
      } catch (error) {
        console.error('Error fetching discounts:', error)
      }
    },
    async addDiscount(discount) {
      try {
        const response = await axiosapi.post('/rent/discount/add', discount)
        this.discounts.push(response.data)
      } catch (error) {
        console.error('Error adding discount:', error)
      }
    },
    async updateDiscount(discount) {
      try {
        const response = await axiosapi.put(`/rent/discount/update/${discount.discountId}`, discount)
        const index = this.discounts.findIndex(d => d.discountId === discount.discountId)
        this.discounts[index] = response.data
      } catch (error) {
        console.error('Error updating discount:', error)
      }
    },
    async deleteDiscount(id) {
      try {
        await axiosapi.delete(`/rent/discount/delete/${id}`)
        this.discounts = this.discounts.filter(d => d.discountId !== id)
      } catch (error) {
        console.error('Error deleting discount:', error)
      }
    }
  }
})
